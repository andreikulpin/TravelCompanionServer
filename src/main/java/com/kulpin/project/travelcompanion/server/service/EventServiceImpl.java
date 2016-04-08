package com.kulpin.project.travelcompanion.server.service;

import com.kulpin.project.travelcompanion.server.entity.Event;
import com.kulpin.project.travelcompanion.server.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService{
    @Autowired
    private EventRepository repository;


    public List<Event> getAll() {
        return repository.findAll();
    }

    public Event getByID(long id) {
        return repository.findOne(id);
    }

    public Event save(Event event) {
        return repository.saveAndFlush(event);
    }

    public void remove(long id) {
        repository.delete(id);
    }
}
