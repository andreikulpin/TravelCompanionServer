package com.kulpin.project.travelcompanion.server.service;

import com.kulpin.project.travelcompanion.server.entity.Photo;
import com.kulpin.project.travelcompanion.server.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository repository;

    public List<Photo> getAll(long eventId){
        List<Photo> list = repository.findAll();
        for (int i =0; i < list.size(); i++){
            if (list.get(i).getEventId() != eventId){
                list.remove(i);
            }
        }
        return list;
    }

    public Photo getById(long id){
        return repository.findOne(id);
    }

    public Photo save(Photo photo){
        System.out.println("save image");
        return repository.saveAndFlush(photo);
    }

    public void remove(long id){
        repository.delete(id);
    }

    public void removeAll(long eventId){
        List<Photo> list = repository.findAll();
        for (int i =0; i < list.size(); i++){
            if (list.get(i).getEventId() == eventId){
                remove(list.get(i).getId());
            }
        }
    }
}
