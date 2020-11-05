package com.githubclient.dto;

import java.io.IOException;

import org.kohsuke.github.GHPerson;

public class GHPersonDto {
	
	private String name;
	private String login;
	private String email;
	private String avatar_url;
	private String blog;
	private String company;
	private int followers;
	private int following;
	private String location;
	private String twitter_username;
	private String type;
	private int commitCount;
	
	/**
	 * Paramterized constructor for the class
	 * @param author
	 * @param commitCount
	 * @throws IOException
	 */
	public GHPersonDto(GHPerson author, int commitCount) throws IOException {
		this.name = author.getName();
		this.login = author.getLogin();
		this.email = author.getEmail();
		this.avatar_url = author.getAvatarUrl();
		this.blog = author.getBlog();
		this.company = author.getCompany();
		this.followers = author.getFollowersCount();
		this.following = author.getFollowingCount();
		this.location = author.getLocation();
		this.twitter_username = author.getTwitterUsername();
		this.type = author.getType();
		this.commitCount = commitCount;
	}

	/*
	 * Getters and Setters
	 */
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar_url() {
		return avatar_url;
	}

	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}

	public String getBlog() {
		return blog;
	}

	public void setBlog(String blog) {
		this.blog = blog;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getFollowers() {
		return followers;
	}

	public void setFollowers(int followers) {
		this.followers = followers;
	}

	public int getFollowing() {
		return following;
	}

	public void setFollowing(int following) {
		this.following = following;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTwitter_username() {
		return twitter_username;
	}

	public void setTwitter_username(String twitter_username) {
		this.twitter_username = twitter_username;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCommitCount() {
		return commitCount;
	}

	public void setCommitCount(int commitCount) {
		this.commitCount = commitCount;
	}
	
}
