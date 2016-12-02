package jp.ac.toho_u.sci.is.nkjm.lec.cs.blog;

import java.util.ArrayList;
import java.util.List;

public class Blogs {

	private List<Blog> blogs = new ArrayList<>();

	public Blogs() {
	}

	public void add(Blog blog) {
		blogs.add(blog);
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

}
