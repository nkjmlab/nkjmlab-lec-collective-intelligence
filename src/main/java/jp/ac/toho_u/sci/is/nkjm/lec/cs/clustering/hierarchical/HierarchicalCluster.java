package jp.ac.toho_u.sci.is.nkjm.lec.cs.clustering.hierarchical;

import java.util.ArrayList;
import java.util.List;

public class HierarchicalCluster {

	private String name;
	private List<Double> counts;
	private HierarchicalCluster left;
	private HierarchicalCluster right;

	public HierarchicalCluster(String name, List<Double> counts, HierarchicalCluster left,
			HierarchicalCluster right) {
		this.name = name;
		this.counts = counts;
		this.left = left;
		this.right = right;
	}

	public String getName() {
		return name;
	}

	public List<Double> getCounts() {
		return counts;
	}

	public static HierarchicalCluster merge(HierarchicalCluster cluster1,
			HierarchicalCluster cluster2) {
		List<Double> aves = new ArrayList<>();
		for (int i = 0; i < cluster1.getCounts().size(); i++) {
			aves.add((cluster1.getCounts().get(i) + cluster2.getCounts().get(i)) / 2);
		}
		return new HierarchicalCluster(cluster1.getName() + "-" + cluster2.getName(), aves,
				cluster1, cluster2);
	}

	public HierarchicalCluster getLeft() {
		return left;
	}

	public HierarchicalCluster getRight() {
		return right;
	}

	@Override
	public String toString() {
		return "name=" + this.name + ",counts=" + counts + ",left=" + this.left.getName()
				+ ",right=" + this.left.getName();
	}

}
