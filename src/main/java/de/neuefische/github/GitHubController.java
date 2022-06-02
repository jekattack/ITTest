package de.neuefische.github;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

//https://api.github.com/users/chrisweber1408/repos

@RestController
@RequestMapping("/github")
@RequiredArgsConstructor
public class GitHubController {

    private final GitHubService gitHubService;
    @GetMapping("/{name}")
    public List<UsersRepo> getRepositories(@PathVariable String name){
        return gitHubService.findRepoFor(name);
    }
}

