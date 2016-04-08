package com.kulpin.project.travelcompanion.server.service;

import com.kulpin.project.travelcompanion.server.entity.Event;

import java.util.List;

public interface EventService {
    List<Event> getAll();
    Event getByID(long id);
    Event save(Event event);
    void remove(long id);
}
