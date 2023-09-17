package com.example.exercise_5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInitializer implements ApplicationRunner {

    private final SightService service;

    @Autowired
    public DBInitializer(SightService service) {
        this.service = service;
    }

    @Override
    public void run(ApplicationArguments args) {

        service.deleteAllSights();

        KeelungSightsCrawler crawler = new KeelungSightsCrawler();

        for (Sight sight : crawler.getSights()) {
            service.createSight(sight);
        }
    }
}
