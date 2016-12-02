package jp.ac.toho_u.sci.is.nkjm.lec.cs;

import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import jp.ac.toho_u.sci.is.nkjm.lec.cs.blog.Blogs;
import jp.ac.toho_u.sci.is.nkjm.lec.cs.blog.BlogsFactory;
import jp.ac.toho_u.sci.is.nkjm.lec.cs.clustering.ClusterElement;
import jp.ac.toho_u.sci.is.nkjm.lec.cs.clustering.hierarchical.HierarchicalCluster;
import jp.ac.toho_u.sci.is.nkjm.lec.cs.clustering.hierarchical.HierarchicalClustering;

public class HierarchicalClusteringOfBlog {
	public static void main(String[] args) {
		Blogs blogs = BlogsFactory.create(Paths.get("data/blogdata.txt"));

		List<ClusterElement> elements = blogs.getBlogs().stream()
				.map(b -> new ClusterElement(b.getName(),
						b.getCounts().stream().map(i -> new Double(i))
								.collect(Collectors.toList())))
				.collect(Collectors.toList());

		HierarchicalCluster result = new HierarchicalClustering().clustering(elements);
		HierarchicalClustering.printCluster(result, 0);
	}
}
