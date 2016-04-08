package com.kulpin.project.travelcompanion.server.repository;

import com.kulpin.project.travelcompanion.server.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
