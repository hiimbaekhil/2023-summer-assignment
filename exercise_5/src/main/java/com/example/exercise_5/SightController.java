package com.example.exercise_5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/SightAPI")
public class SightController {

    private final SightService service;

    @Autowired
    public SightController(SightService service) {
        this.service = service;
    }

    @GetMapping
    public List<Sight> getSights(@RequestParam("zone") String zone) {

        if (zone.equals("全部")) {
            return service.getAllSights();
        }

        return service.getSights(zone);
    }
}
