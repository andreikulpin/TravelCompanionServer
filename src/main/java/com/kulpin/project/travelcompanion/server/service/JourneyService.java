package com.kulpin.project.travelcompanion.server.service;

import com.kulpin.project.travelcompanion.server.entity.Event;
import com.kulpin.project.travelcompanion.server.entity.Journey;
import com.kulpin.project.travelcompanion.server.repository.JourneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JourneyService {
    @Autowired
    private JourneyRepository repository;

    public List<Journey> getAll() {
        return repository.findAll();
    }

    public Journey getByID(long id) {
        return repository.findOne(id);
    }

    public Journey save(Journey journey) {
        return repository.saveAndFlush(journey);
    }

    public void remove(long id) {
        repository.delete(id);
    }
}
