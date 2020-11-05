package com.githubclient.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.githubclient.dto.GHPersonDto;
import com.githubclient.dto.GHRepositoryDto;
import com.githubclient.request.QueryRequestModel;
import com.githubclient.services.GithubRepositoryService;

/**
 * Presentation Layer - The main controller that contains the only end point that listens to the requests
 * for querying top m committees of top n repos of an organization.
 * Interacts with the Service Layer
 * @author Saurabh Singh
 */
@RestController
@RequestMapping("/org")
public class MainController {
	
	@Autowired
	GithubRepositoryService githubRepositoryService;
	
	
	/**
	 * Fetches and returns the list of m topmost committees in order of their commit counts in the topmost n repositories of
	 * the requested organization
	 * @param query - QueryRequestModel object containing the organization name, n, and m.
	 * @return List of GHRepositoryDto objects
	 * @throws Exception
	 */
	@PostMapping(
			consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public List<GHRepositoryDto> getCommittees(@RequestBody QueryRequestModel query) throws Exception {
		return githubRepositoryService.getTopKCommittees(query.getOrganisationName(), query.getN(), query.getM());
	}

}
