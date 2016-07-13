package com.kulpin.project.travelcompanion.server.controller;

import com.kulpin.project.travelcompanion.server.entity.Event;
import com.kulpin.project.travelcompanion.server.entity.Journey;
import com.kulpin.project.travelcompanion.server.service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("journeys")
public class JourneyController {

    @Autowired
    private JourneyService service;

    @RequestMapping(value = "/all/{id_user}", method = RequestMethod.GET)
    @ResponseBody
    public List<Journey> getAllJourneys(@PathVariable("id_user") long userID){
        return service.getAll(userID);
    }

    @RequestMapping(value = "/active/{id_user}", method = RequestMethod.GET)
    @ResponseBody
    public List<Journey> getActiveJourneys(@PathVariable("id_user") long userID){
        return service.getActive(userID);
    }

    @RequestMapping(value = "/last/{id_user}", method = RequestMethod.GET)
    @ResponseBody
    public List<Journey> getLastJourneys(@PathVariable("id_user") long userID){
        return service.getLast(userID);
    }

    @RequestMapping(value = "/journeyById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Journey getJourney(@PathVariable("id") long journeyID){
        return service.getByID(journeyID);
    }

    @RequestMapping(value = "/newJourney", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Journey> saveJourney(@RequestBody Journey journey){
        //journey.setUserId(1);
        service.save(journey);
        return new ResponseEntity<Journey>(journey, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable("id") long id){
        service.remove(id);
    }
}
