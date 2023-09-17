package com.example.exercise_5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SightService {

    private final SightRepository repository;

    @Autowired
    public SightService(SightRepository repository) {
        this.repository = repository;
    }

    public void deleteAllSights() {
        repository.deleteAll();
    }

    public void createSight(Sight sight) {
        repository.insert(sight);
    }

    public List<Sight> getAllSights() {
        return repository.findAll();
    }

    public List<Sight> getSights(String zone) {
        return repository.findByZone(zone);
    }
}
