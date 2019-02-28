package com.rest.app.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.app.model.Welcoming;
import com.rest.app.repository.WelcomingRepository;

@Service
public class WelcomingServiceBean implements WelcomingService {
	//inject the WelcomingRepository
	@Autowired
	private WelcomingRepository welRepository;
	
	@Override
	public Collection<Welcoming> findAll() {
		Collection<Welcoming> welcomes = welRepository.findAll();
		return welcomes;
	}

	@Override
	public Welcoming find(Long id) {
		Welcoming w = welRepository.getOne(id);
		return w;
	}

	@Override
	public Welcoming create(Welcoming welcome) {
		if(welcome.getId() != null){
			//not create with null id
			return null;
		}
		Welcoming savedWelcoming = welRepository.save(welcome);
		return savedWelcoming;
	}
	
	@Override
	public Welcoming update(Welcoming welcome){
		Welcoming WelPersisted =find(welcome.getId());
		if(WelPersisted == null){
			//not update that has not been persisted
			return null;
		}
		
		Welcoming updatedWelcoming = welRepository.save(welcome);
		return updatedWelcoming;
	}
	
	@Override
	public void delete(Long id){
		welRepository.deleteById(id);;		
	}

}
