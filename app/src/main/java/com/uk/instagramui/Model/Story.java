package com.uk.instagramui.Model;

public class Story {
	private String imageUrl;
	private boolean outline;
	
	public Story(String imageUrl, boolean outline) {
		this.imageUrl = imageUrl;
		this.outline = outline;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public boolean isOutline() {
		return outline;
	}
	
	public void setOutline(boolean outline) {
		this.outline = outline;
	}
}
