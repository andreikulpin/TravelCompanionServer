package com.kulpin.project.travelcompanion.server.repository;

import com.kulpin.project.travelcompanion.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Andrei on 15.04.2016.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}