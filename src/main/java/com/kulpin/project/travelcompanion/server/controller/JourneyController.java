package com.kulpin.project.travelcompanion.server.controller;

import com.kulpin.project.travelcompanion.server.entity.Event;
import com.kulpin.project.travelcompanion.server.entity.Journey;
import com.kulpin.project.travelcompanion.server.service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class JourneyController {

    @Autowired
    private JourneyService service;

    @RequestMapping(value = "/journeys", method = RequestMethod.GET)
    @ResponseBody
    public List<Journey> getAllJourneys(){
        return service.getAll();
    }

    @RequestMapping(value = "/journeys/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Journey getJourney(@PathVariable("id") long journeyID){
        return service.getByID(journeyID);
    }

    @RequestMapping(value = "/journeys", method = RequestMethod.POST)
    @ResponseBody
    public Journey saveJourney(@RequestBody Journey journey){
        return service.save(journey);
    }

    @RequestMapping(value = "/journeys/{id}", method = RequestMethod.POST)
    @ResponseBody
    public void delete(@PathVariable("id") long id){
        service.remove(id);
    }
}
