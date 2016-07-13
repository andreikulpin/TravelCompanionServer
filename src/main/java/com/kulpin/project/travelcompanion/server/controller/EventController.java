package com.kulpin.project.travelcompanion.server.controller;

import com.kulpin.project.travelcompanion.server.entity.Event;
import com.kulpin.project.travelcompanion.server.service.EventService;
import com.kulpin.project.travelcompanion.server.service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("events")
public class EventController {
    @Autowired
    private EventService eventService;

    @Autowired
    private JourneyService journeyService;

    @RequestMapping(value = "/all/{id_journey}", method = RequestMethod.GET)
    @ResponseBody
    public List<Event> getAllEvents(@PathVariable("id_journey") long journeyID){
        return eventService.getAll(journeyID);
    }

    @RequestMapping(value = "/eventById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Event getEvent(@PathVariable("id") long eventID){
        return eventService.getByID(eventID);
    }

    @RequestMapping(value = "/newEvent", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Event> saveEvent(@RequestBody Event event){
        event.setUserId(journeyService.getByID(event.getJourneyId()).getUserId());
        eventService.save(event);
        return new ResponseEntity<Event>(event, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable("id") long id){
        eventService.remove(id);
    }


    @RequestMapping(value = "/get_string", method = RequestMethod.GET)
    @ResponseBody
    public String getString(ModelMap model){
        return "event";
    }
}
