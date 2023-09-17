package com.example.exercise_5;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SightRepository extends MongoRepository<Sight, String> {

    List<Sight> findByZone(String zone);
}
