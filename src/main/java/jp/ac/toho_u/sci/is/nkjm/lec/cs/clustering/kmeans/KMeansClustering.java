package jp.ac.toho_u.sci.is.nkjm.lec.cs.clustering.kmeans;

import java.util.List;

import jp.ac.toho_u.sci.is.nkjm.lec.cs.clustering.ClusterElement;

public class KMeansClustering {

	private String name;
	private List<ClusterElement> elements;

	public KMeansClustering(String name, List<ClusterElement> elements) {
		this.name = name;
		this.elements = elements;
	}

	public String getName() {
		return name;
	}

	public List<ClusterElement> getElements() {
		return elements;
	}

}
