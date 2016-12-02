package jp.ac.toho_u.sci.is.nkjm.lec.cs.blog;

import java.util.ArrayList;
import java.util.List;

public class Blog {

	private String name;
	private List<String> words;
	private List<Integer> counts;

	public Blog(String name, List<String> words, List<Integer> wordCounts) {
		this.name = name;
		this.counts = new ArrayList<>(wordCounts);
		this.words = new ArrayList<>(words);
	}

	public List<Integer> getCounts() {
		return counts;
	}

	public String getName() {
		return name;
	}

}
