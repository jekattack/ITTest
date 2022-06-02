package de.neuefische.github;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class GitHubControllerTestIT {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private GitHubService gitHubService;

    /*
    @Test
    void shouldGetReposFromUser(){
        //given
        String name = "chrisweber1408";

        UsersRepo repo1 = new UsersRepo("FirstSpringBootProject");
        UsersRepo repo2 = new UsersRepo("FreitagsaufgabeWeek2");
        UsersRepo repo3 = new UsersRepo("Github-Aufgabe1");
        UsersRepo repo4 = new UsersRepo("Test");
        UsersRepo repo5 = new UsersRepo("Week1");
        UsersRepo repo6 = new UsersRepo("Week2_Uebungen");

        List<UsersRepo> repoList = new ArrayList<>();
        repoList.add(repo1);
        repoList.add(repo2);
        repoList.add(repo3);
        repoList.add(repo4);
        repoList.add(repo5);
        repoList.add(repo6);

        //when
        ResponseEntity<UsersRepo[]> actual = restTemplate.getForEntity("/github/" + name, UsersRepo[].class);
        Assertions.assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
        //then
        Assertions.assertThat(actual.getBody()).containsAll(repoList);
    }

     */



    @Test
    void shouldGetReposFromUser(){


        //given
        String name = "chrisweber1408";

        UsersRepo repo1 = new UsersRepo("FirstSpringBootProject");
        UsersRepo repo2 = new UsersRepo("FreitagsaufgabeWeek2");
        UsersRepo repo3 = new UsersRepo("Github-Aufgabe1");
        UsersRepo repo4 = new UsersRepo("Test");
        UsersRepo repo5 = new UsersRepo("Week1");
        UsersRepo repo6 = new UsersRepo("Week2_Uebungen");

        List<UsersRepo> repoList = new ArrayList<>();
        repoList.add(repo1);
        repoList.add(repo2);
        repoList.add(repo3);
        repoList.add(repo4);
        repoList.add(repo5);
        repoList.add(repo6);

        //when
        when(gitHubService.findRepoFor(name)).thenReturn(repoList);

        ResponseEntity<UsersRepo[]> actual = restTemplate.getForEntity("/github/" + name, UsersRepo[].class);
        Assertions.assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
        //then
        Assertions.assertThat(actual.getBody()).containsAll(repoList);
    }

}