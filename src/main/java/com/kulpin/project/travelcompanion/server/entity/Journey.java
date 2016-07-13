package com.kulpin.project.travelcompanion.server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "journey")
public class Journey implements Comparable{
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column(name = "id_user", nullable = false)
    private long userId;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    public Journey() {
    }

    public long getId() {
        return id;
    }

    public void setId(long journeyId) {
        this.id = journeyId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    //@Override
    public int compareTo(Object object) {
        Journey secondJourney = (Journey) object;
        if (this.getStartDate().getTime() < secondJourney.getStartDate().getTime()) return -1;
        if (this.getStartDate().getTime() > secondJourney.getStartDate().getTime()) return 1;
        return 0;
    }
}