package com.kulpin.project.travelcompanion.server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table (name = "photo")
public class Photo {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column (name = "id_event", nullable = false)
    private long eventId;

    @Column (name = "id_journey", nullable = false)
    private long journeyId;

    @Lob
    @Column(name = "lob_photo")
    private byte[] lob;

    @Column(name = "title_photo", nullable = false)
    private String photoTitle;

    public Photo() {
    }

    public Photo(long eventId, byte[] lob, String photoTitle) {
        this.eventId = eventId;
        this.lob = lob;
        this.photoTitle = photoTitle;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public long getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(long journeyId) {
        this.journeyId = journeyId;
    }

    public byte[] getLob() {
        return lob;
    }

    public void setLob(byte[] lob) {
        this.lob = lob;
    }

    public String getPhotoTitle() {
        return photoTitle;
    }

    public void setPhotoTitle(String photoTitle) {
        this.photoTitle = photoTitle;
    }
}
