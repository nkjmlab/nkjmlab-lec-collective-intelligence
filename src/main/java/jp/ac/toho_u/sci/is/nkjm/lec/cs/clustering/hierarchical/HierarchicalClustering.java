package jp.ac.toho_u.sci.is.nkjm.lec.cs.clustering.hierarchical;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.ac.toho_u.sci.is.nkjm.lec.cs.clustering.ClusterElement;
import jp.ac.toho_u.sci.is.nkjm.lec.cs.distance.Pearson;

public class HierarchicalClustering {
	private static Logger log = LogManager.getLogger();

	public HierarchicalCluster clustering(List<ClusterElement> elements) {

		List<HierarchicalCluster> clusters = elements.stream()
				.map(e -> new HierarchicalCluster(e.getName(), e.getCounts(), null, null))
				.collect(Collectors.toList());

		List<HierarchicalCluster> nexts = new ArrayList<>(clusters);

		while (nexts.size() != 1) {
			log.info("clusters size is {}", nexts.size());
			double closest = Double.MAX_VALUE;
			List<HierarchicalCluster> minPair = null;

			for (int i = 0; i < nexts.size(); i++) {
				for (int j = 0; j < nexts.size(); j++) {
					if (i == j) {
						continue;
					}
					double distance = new Pearson().distance(nexts.get(i).getCounts(),
							nexts.get(j).getCounts());
					if (distance < closest) {
						closest = distance;
						minPair = new ArrayList<>();
						minPair.add(nexts.get(i));
						minPair.add(nexts.get(j));
					}
				}
			}
			nexts.removeAll(minPair);
			nexts.add(HierarchicalCluster.merge(minPair.get(0), minPair.get(1)));
		}
		return nexts.get(0);
	}

	public static void printCluster(HierarchicalCluster cluster, int indent) {
		String str = "";
		for (int i = 0; i < indent; i++) {
			str += " ";
		}

		if (isLeaf(cluster)) {
			System.out.println(str + cluster.getName());
		} else {
			System.out.println(str + "-");
		}

		if (cluster.getLeft() != null) {
			printCluster(cluster.getLeft(), indent + 1);
		}
		if (cluster.getRight() != null) {
			printCluster(cluster.getRight(), indent + 1);
		}

	}

	private static boolean isLeaf(HierarchicalCluster cluster) {
		return cluster.getLeft() == null && cluster.getRight() == null;
	}

}
