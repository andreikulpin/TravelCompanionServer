package com.kulpin.project.travelcompanion.server.repository;

import com.kulpin.project.travelcompanion.server.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
