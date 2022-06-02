package de.neuefische.github;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class GitHubControllerTestIT {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldGetReposFromUser(){
        //given
        String name = "chrisweber1408";
        List<String> repos = List.of(
                "FirstSpringBootProject",
                "FreitagsaufgabeWeek2",
                "Github-Aufgabe1",
                "Test",
                "Week1",
                "Week2_Uebungen");
        //when
        ResponseEntity<String[]> actual = restTemplate.getForEntity("/github/" + name, String[].class);
        Assertions.assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
        //then
        Assertions.assertThat(actual.getBody()).containsAll(repos);
    }
}