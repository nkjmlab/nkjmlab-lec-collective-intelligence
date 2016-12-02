package jp.ac.toho_u.sci.is.nkjm.lec.cs.clustering;

import java.util.List;

public class ClusterElement {

	private String name;
	private List<Double> counts;

	public ClusterElement(String name, List<Double> counts) {
		this.name = name;
		this.counts = counts;
	}

	public List<Double> getCounts() {
		return counts;
	}

	public String getName() {
		return name;
	}

}
