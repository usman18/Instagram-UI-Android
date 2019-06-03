package com.uk.instagramui.Model;

public class TimelinePost {
	private String profilePic;
	private String name;
	private String imageUrl;
	private int likes;
	private String caption;
	private String date;
	
	public TimelinePost(String profilePic, String name, String imageUrl, int likes, String caption, String date) {
		this.profilePic = profilePic;
		this.name = name;
		this.imageUrl = imageUrl;
		this.likes = likes;
		this.caption = caption;
		this.date = date;
	}
	
	
	public String getProfilePic() {
		return profilePic;
	}
	
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public int getLikes() {
		return likes;
	}
	
	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	public String getCaption() {
		return caption;
	}
	
	public void setCaption(String caption) {
		this.caption = caption;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
}
