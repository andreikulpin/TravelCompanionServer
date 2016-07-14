package com.kulpin.project.travelcompanion.server.controller;

import com.kulpin.project.travelcompanion.server.entity.Photo;
import com.kulpin.project.travelcompanion.server.service.EventService;
import com.kulpin.project.travelcompanion.server.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.List;

/**
 * Created by Andrei on 13.07.2016.
 */

@RestController
@RequestMapping("photos")
public class PhotoController {

    @Autowired
    private PhotoService service;

    @Autowired
    private EventService eventService;

    @RequestMapping(value = "/addphoto", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Photo> addPhoto(@RequestBody Photo photo){
        //System.out.println("addPhoto" + photo);
        if (eventService.getByID(photo.getEventId()) != null)
            photo.setJourneyId(eventService.getByID(photo.getEventId()).getJourneyId());
        service.save(photo);
        return new ResponseEntity<Photo>(photo, HttpStatus.OK);
    }

    @RequestMapping(value = "/photoById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Photo get(@PathVariable ("id") long photoId){
        Photo photo = service.getById(photoId);
        try{
            FileOutputStream fos = new FileOutputStream("D:\\out.jpg");
            fos.write(photo.getLob());
            fos.close();
        }catch (FileNotFoundException e){}
        catch (IOException e){}
        return photo;
    }

    @RequestMapping(value = "/all/{id_event}", method = RequestMethod.GET)
    @ResponseBody
    public List<Photo> getAllPhotos(@PathVariable ("id_event") long eventId){
        return service.getAll(eventId);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable("id") long id){
        service.remove(id);
    }

    @RequestMapping(value = "/deleteAll/{id_event}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@PathVariable("id_event") long eventId){
        service.removeAll(eventId);
    }


    /*tests*/
    @RequestMapping(value = "/save/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Photo save(@PathVariable int id){
        File file = new File("D:\\" + id + ".jpg");
        byte[] bytePhoto = new byte[(int)file.length()];

        try{
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytePhoto);
            fileInputStream.close();

            Photo photo = new Photo(1, bytePhoto, file.getAbsolutePath());
            service.save(photo);
            return photo;
        }
        catch (FileNotFoundException e){}
        catch (IOException e){}

        return null;
    }

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    @ResponseBody
    public String test1(){
        File file = new File("D:\\1.txt");
        String s = "";

        try{
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
            s = reader.readLine();
            reader.close();
            fileInputStream.close();
        }
        catch (FileNotFoundException e){}
        catch (IOException e){}
        return s;
    }
}
