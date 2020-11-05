package com.githubclient.services;
import java.io.IOException;
import java.util.List;

import com.githubclient.dto.GHPersonDto;
import com.githubclient.dto.GHRepositoryDto;

/**
 * Interface for the GithubRepositoryService that is implemented by GithubRepositoryServiceImpl class.
 * @author Saurabh Singh
 *
 */
public interface GithubRepositoryService {
	
	public List<GHRepositoryDto> getTopKCommittees(String orgName, int n, int m) throws IOException;	
}
