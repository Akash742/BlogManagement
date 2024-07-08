package com.accenture.lkm.bean;

import org.hibernate.validator.constraints.NotEmpty;

public class BlogBean {


	private int blogId;
	
	@NotEmpty(message="May not be Empty")
	private String email;
	@NotEmpty(message="May not be Empty")
	private String title;
	
	private String themes;
	@NotEmpty(message="May not be Empty")
	private String content;




	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThemes() {
		return themes;
	}

	public void setThemes(String themes) {
		this.themes = themes;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
}
