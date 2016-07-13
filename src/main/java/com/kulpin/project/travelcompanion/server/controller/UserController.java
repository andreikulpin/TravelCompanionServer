package com.kulpin.project.travelcompanion.server.controller;

import com.kulpin.project.travelcompanion.server.entity.Event;
import com.kulpin.project.travelcompanion.server.entity.User;
import com.kulpin.project.travelcompanion.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers(){
        return service.getAll();
    }

    @RequestMapping(value = "/userById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable("id") long userID){
        return service.getByID(userID);
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<User> saveUser(@RequestBody User user){
        service.save(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public void delete(@PathVariable("id") long id){
        service.remove(id);
    }
}
