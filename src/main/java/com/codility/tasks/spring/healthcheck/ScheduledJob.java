package com.codility.tasks.spring.healthcheck;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@EnableScheduling
@Component
public class ScheduledJob {

    @Scheduled(fixedRate = 10000)
    public void printResult() {

        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<Posts[]> response = restTemplate.exchange("https://jsonplaceholder.typicode.com/posts", HttpMethod.GET, null, Posts[].class);
            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
