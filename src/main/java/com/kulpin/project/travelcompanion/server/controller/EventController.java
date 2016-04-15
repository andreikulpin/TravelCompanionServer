package com.kulpin.project.travelcompanion.server.controller;


import com.kulpin.project.travelcompanion.server.entity.Event;
import com.kulpin.project.travelcompanion.server.service.EventService;
import com.kulpin.project.travelcompanion.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class EventController {
    @Autowired
    private EventService service;

    @RequestMapping(value = "/get_string", method = RequestMethod.GET)
    @ResponseBody
    public String getString(ModelMap model){
        return "event";
    }

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    @ResponseBody
    public List<Event> getAllEvents(){
        return service.getAll();
    }

    @RequestMapping(value = "/events/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Event getEvent(@PathVariable("id") long eventID){
        return service.getByID(eventID);
    }

    @RequestMapping(value = "/events", method = RequestMethod.POST)
    @ResponseBody
    public Event saveEvent(@RequestBody Event event){
        return service.save(event);
    }

    @RequestMapping(value = "/events/{id}", method = RequestMethod.POST)
    @ResponseBody
    public void delete(@PathVariable("id") long id){
        service.remove(id);
    }


}
