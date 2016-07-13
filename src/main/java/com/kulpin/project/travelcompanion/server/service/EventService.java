package com.kulpin.project.travelcompanion.server.service;

import com.kulpin.project.travelcompanion.server.entity.Event;
import com.kulpin.project.travelcompanion.server.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EventService{
    @Autowired
    private EventRepository repository;

    public List<Event> getAll(long journeyID) {
        List<Event> listEvent = repository.findAll();
        for (int i = 0; i < listEvent.size(); i++){
            if (listEvent.get(i).getJourneyId() != journeyID) {
                listEvent.remove(i);
                i--;
            }
        }
        Collections.sort(listEvent);
        return listEvent;
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
