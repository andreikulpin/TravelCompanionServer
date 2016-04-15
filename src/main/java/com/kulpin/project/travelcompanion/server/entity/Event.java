package com.kulpin.project.travelcompanion.server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id_event;

    @Column(name = "id_user", nullable = false)
    private long id_user;

    @Column(name = "id_journey", nullable = false)
    private long id_journey;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "place", nullable = false, length = 50)
    private String place;

    @Column(name = "eventDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventDate;

    @Column(name = "distance", nullable = false)
    private float distance;

    public Event() {
    }

    public long getId() {
        return id_event;
    }

    public void setId(long id) {
        this.id_event = id;
    }

    public long getUserId() {
        return id_user;
    }

    public void setUserId(long userId) {
        this.id_user = userId;
    }

    public long getJourneyId() {
        return id_user;
    }

    public void setJourneyId(long journeyId) {
        this.id_user = journeyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }
}
