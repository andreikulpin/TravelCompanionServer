package com.kulpin.project.travelcompanion.server.service;

import com.kulpin.project.travelcompanion.server.entity.User;
import com.kulpin.project.travelcompanion.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getByID(long id){
        return repository.findOne(id);
    };

    public User save(User user) {
        return repository.saveAndFlush(user);
    }

    public void remove(long id){
        repository.delete(id);
    };
}
