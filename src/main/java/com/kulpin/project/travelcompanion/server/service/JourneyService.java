package com.kulpin.project.travelcompanion.server.service;

import com.kulpin.project.travelcompanion.server.entity.Event;
import com.kulpin.project.travelcompanion.server.entity.Journey;
import com.kulpin.project.travelcompanion.server.repository.JourneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class JourneyService {
    @Autowired
    private EventService eventService;
    @Autowired
    private JourneyRepository repository;



    public List<Journey> getAll(long userID) {
        List<Journey> listJourney = repository.findAll();
        for (int i = 0; i < listJourney.size(); i++){
            if (listJourney.get(i).getUserId() != userID) {
                listJourney.remove(i);
                i--;
            }
        }

        Collections.sort(listJourney);
        return listJourney;
    }

    public List<Journey> getActive(long userID) {
        List<Journey> listJourney = repository.findAll();
        for (int i = 0; i < listJourney.size(); i++){
            if ((listJourney.get(i).getUserId() != userID) || (listJourney.get(i).getEndDate().getTime() < (new Date().getTime()))) {
                listJourney.remove(i);
                i--;
            }
        }
        Collections.sort(listJourney);
        return listJourney;
    }

    public List<Journey> getLast(long userID) {
        List<Journey> listJourney = repository.findAll();
        for (int i = 0; i < listJourney.size(); i++){
            if ((listJourney.get(i).getUserId() != userID) || (listJourney.get(i).getEndDate().getTime() > (new Date().getTime()))) {
                listJourney.remove(i);
                i--;
            }
        }
        Collections.sort(listJourney);
        return listJourney;
    }

    public Journey getByID(long id) {
        return repository.findOne(id);
    }

    public Journey save(Journey journey) {
        return repository.saveAndFlush(journey);
    }

    public void remove(long id) {
        List<Event> events = eventService.getAll(id);
        for (Event event : events){
            eventService.remove(event.getId());
        }
        repository.delete(id);
    }

    public class JourneyComparator implements Comparator<Journey> {
        //@Override
        public int compare(Journey journey_1, Journey journey_2) {

            if (journey_1.getStartDate().getTime() < journey_2.getStartDate().getTime()) return -1;
            if (journey_1.getStartDate().getTime() > journey_2.getStartDate().getTime()) return 1;
            return 0;
        }
    }
}
