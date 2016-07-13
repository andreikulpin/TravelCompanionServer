package com.kulpin.project.travelcompanion.server.repository;

import com.kulpin.project.travelcompanion.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
