package com.example.universinal;

public class ListViewItem {
	String content;
	String imageUrl;
	public ListViewItem(String content,String imageUrl)
	{
		this.content = content;
		this.imageUrl = imageUrl;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
}
