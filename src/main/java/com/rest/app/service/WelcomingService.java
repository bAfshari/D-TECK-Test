package com.rest.app.service;

import java.util.Collection;

import com.rest.app.model.Welcoming;

public interface WelcomingService {
	Collection<Welcoming> findAll();
	Welcoming find(Long id);
	Welcoming create(Welcoming welcome);
	Welcoming update(Welcoming welcome);
	void delete(Long id);

}
