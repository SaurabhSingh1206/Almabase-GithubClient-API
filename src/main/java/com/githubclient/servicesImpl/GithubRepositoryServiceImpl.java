package com.githubclient.servicesImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kohsuke.github.GHCommit;
import org.kohsuke.github.GHOrganization;
import org.kohsuke.github.GHPerson;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.kohsuke.github.PagedIterable;
import org.springframework.stereotype.Service;

import com.githubclient.dto.GHPersonDto;
import com.githubclient.dto.GHRepositoryDto;
import com.githubclient.services.GithubRepositoryService;

/**
 * Implementation of the GithubRepositoryService - Interacts with the Presentation Layer
 * @author Saurabh Singh
 *
 */
@Service
public class GithubRepositoryServiceImpl implements GithubRepositoryService {

	
	private String userName;
	private String password;
	private GitHub github;
	
	/**
	 * Constructor for the class that initializes the GithubClient to talk with the Github API.
	 * @throws IOException
	 */
	public GithubRepositoryServiceImpl() throws IOException {
		this.userName = "SaurabhSingh1206";
		this.password = "rustie@123";
		this.github = new GitHubBuilder().withPassword(this.userName, this.password).build();
	}
	
	/**
	 * Fetches all the repositories of the query organization and then sorts them on the basis of their fork counts in non-increasing order
	 * (conflicts resolved on the basis of their lexicographic naming order) and then extracts the top m committees of those repositories.
	 * @param orgName - The name of the organization
	 * @param n - The number of repositories to extract
	 * @param m - The number of committees to extract
	 * @return List of GHRepositoryDto class
	 * @throws IOException
	 * @author Saurabh Singh
	 * @implNote The below implementation works in O(n log n + m) time.
	 */
	@Override
	public List<GHRepositoryDto> getTopKCommittees(String orgName, int n, int m) throws IOException {
		GHOrganization org =  this.github.getOrganization(orgName);
		Map<String, GHRepository> map = org.getRepositories(); // get all the repositories
		List<GHRepository> allRepo = new ArrayList<>(); 
		for(String repoName : map.keySet()) {
			allRepo.add(map.get(repoName));	// convert the returned map to a list
		}
		Collections.sort(allRepo, new Comparator<GHRepository>() { // sort on the basis of their fork counts
			@Override
			public int compare(GHRepository repo1, GHRepository repo2) {
				return repo2.getForksCount() - repo1.getForksCount();
			}
		});
		List<GHRepositoryDto> toReturn = new ArrayList<>(); //stores the result list to return
		for (int i = 0; i < Math.min(n, allRepo.size()); i++) {
			PagedIterable<GHCommit> iterator = allRepo.get(i).listCommits(); // get all the commits of a repository
			String repoName = allRepo.get(i).getName(); // name of the repository
			String repoOwner = allRepo.get(i).getOwnerName(); // name of the owner of the repository
			List<GHCommit> commits = iterator.toList(); // get all the commits of of the repository in a list
			Map<Long, Integer> idToCount = new HashMap<>(); // map from id -> commit count of a person
			Map<Long, GHPerson> idToPerson = new HashMap<>(); // map from id -> GHPerson object
			for (GHCommit commit : commits) {
				GHPerson author = commit.getAuthor();
				if (author == null)	continue;
				long authorId = author.getId();
				idToCount.put(authorId, idToCount.getOrDefault(authorId, 0) + 1);
				idToPerson.put(authorId, author);
			}
			List<IDtoCountClass> allCommittees = new ArrayList<>(); // all committees for a particular repository
			for (long id : idToCount.keySet()) {
				allCommittees.add(new IDtoCountClass(id, idToCount.get(id)));
			}
			Collections.sort(allCommittees, new Comparator<IDtoCountClass>() {
				@Override
				public int compare(IDtoCountClass obj1, IDtoCountClass obj2) {
					return obj2.count - obj1.count;
				}
			});
			List<GHPersonDto> topKAuthors = new ArrayList<>(); //stores the top k authors/ committees 
			for (int j = 0; j < Math.min(m, allCommittees.size()); j++) {
				topKAuthors.add(new GHPersonDto(idToPerson.get(allCommittees.get(j).id), allCommittees.get(j).count));
			}			
			toReturn.add(new GHRepositoryDto(repoName, repoOwner, topKAuthors));
		}
		System.out.println("Just returning");
		return toReturn;
	}
	
	private class IDtoCountClass {
		private long id;
		private int count;
		public IDtoCountClass(long id, int count) {
			this.id = id;
			this.count = count;
		}
	}

}
