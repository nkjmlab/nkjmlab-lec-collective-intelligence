package jp.ac.toho_u.sci.is.nkjm.lec.cs.blog;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlogsFactory {

	public static void main(String[] args) {
		Blogs blogs = create(Paths.get("data/blogdata.txt"));
		System.out.println(blogs);

	}

	public static Blogs create(Path path) {
		Blogs blogs = new Blogs();
		try {
			List<String> lines = Files.readAllLines(path);
			List<String> words = createWords(lines.get(0));
			for (int i = 1; i < lines.size(); i++) {
				blogs.add(createBlog(words, lines.get(i)));
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return blogs;
	}

	private static Blog createBlog(List<String> words, String line) {
		String[] elems = line.split("\t");
		List<Integer> wordCounts = new ArrayList<>();
		for (int i = 0; i < words.size(); i++) {
			wordCounts.add(Integer.parseInt(elems[i + 1]));
		}
		String blogName = elems[0];

		return new Blog(blogName, words, wordCounts);
	}

	private static List<String> createWords(String headline) {
		String[] elems = headline.split("\t");
		return Arrays.asList(elems).subList(1, elems.length - 1);
	}
}
