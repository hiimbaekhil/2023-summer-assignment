package com.example.exercise_4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/SightAPI")
public class SightController {

    private final KeelungSightsCrawler crawler = new KeelungSightsCrawler();

    @GetMapping
    public List<Sight> getSights(@RequestParam("zone") String zone) {
        return crawler.getItems(zone);
    }
}
