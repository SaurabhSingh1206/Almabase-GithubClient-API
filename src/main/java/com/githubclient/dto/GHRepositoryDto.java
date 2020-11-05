package com.githubclient.dto;

import java.util.List;

/**
 * Data Transfer Object between the presentation layer and service layer
 * @author Saurabh Singh
 *
 */
public class GHRepositoryDto {
	
	private String name;
	private String owner;
	private List<GHPersonDto> topKCommittees;
	
	public GHRepositoryDto(String name, String owner, List<GHPersonDto> topKCommittees) {
		this.name = name;
		this.owner = owner;
		this.topKCommittees = topKCommittees;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public List<GHPersonDto> getTopKCommittees() {
		return topKCommittees;
	}

	public void setTopKCommittees(List<GHPersonDto> topKCommittees) {
		this.topKCommittees = topKCommittees;
	}

}
