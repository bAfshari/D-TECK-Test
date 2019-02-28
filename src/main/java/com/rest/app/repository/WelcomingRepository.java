package com.rest.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.app.model.Welcoming;

@Repository
public interface WelcomingRepository extends JpaRepository<Welcoming, Long> {
	
}
