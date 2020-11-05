package com.githubclient.request;

public class QueryRequestModel {
	private String organisationName; // stores the input organization name
	private int n; // stores n
	private int m; // stores m
	
	/**
	 * Parameterized Constructor for the class
	 * @param organisationName
	 * @param n
	 * @param m
	 */
	public QueryRequestModel(String organisationName, int n, int m) {
		super();
		this.organisationName = organisationName;
		this.n = n;
		this.m = m;
	}
	public String getOrganisationName() {
		return organisationName;
	}
	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
}
