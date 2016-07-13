package com.kulpin.project.travelcompanion.server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "event")
public class Event implements Comparable{
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column(name = "id_user", nullable = false)
    private long userId;

    @Column(name = "id_journey", nullable = false)
    private long journeyId;

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

    public Event(String title, long journeyId, long userId) {
        this.title = title;
        this.journeyId = journeyId;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long eventId) {
        this.id = eventId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(long journeyId) {
        this.journeyId = journeyId;
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

    //@Override
    public int compareTo(Object object) {
        Event secondEvent = (Event)object;
        if (this.eventDate.getTime() < secondEvent.getEventDate().getTime()) return -1;
        if (this.eventDate.getTime() > secondEvent.getEventDate().getTime()) return 1;
        return 0;
    }
}
