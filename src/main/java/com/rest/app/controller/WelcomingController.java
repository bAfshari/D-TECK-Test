package com.rest.app.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.app.model.Welcoming;
import com.rest.app.service.WelcomingService;

//convert the object return from controller method into JSON or XML responses 
@RestController
public class WelcomingController {
	
	//Tells spring to inject some instances of welcoming to controller class
	@Autowired
	private WelcomingService welcomingService;
		
	//return the format of http response and recieve http request
	@RequestMapping(
			value = "/api/welcomings", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Welcoming>>getWelcoming(){
		
		
		Collection<Welcoming> welcomes = welcomingService.findAll();
		return new ResponseEntity<Collection<Welcoming>>(welcomes, HttpStatus.OK);
	}
	
	//return only one object that is match to the primary key
	@RequestMapping(
			value = "/api/welcomings/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Welcoming> getWelcoming(@PathVariable ("id") long id){
		Welcoming w = welcomingService.find(id);
		if (w == null){
			return new ResponseEntity<Welcoming>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Welcoming>(w, HttpStatus.OK);		
	}
	
	//creates request body with JSON
	@RequestMapping(
			value = "/api/welcomings",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Welcoming> createWelcoming(@RequestBody Welcoming welcome){
		Welcoming savedWelcoming = welcomingService.create(welcome);
		return new ResponseEntity<Welcoming>(savedWelcoming, HttpStatus.CREATED);
	}
	
	@RequestMapping(
			value = "/api/welcomings/{id}",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Welcoming> updateWelcoming(@RequestBody Welcoming welcome){
		Welcoming updatedWelcoming = welcomingService.update(welcome);
		if (updatedWelcoming == null){
			return new ResponseEntity<Welcoming>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Welcoming>(updatedWelcoming, HttpStatus.CREATED);
	}
	
	@RequestMapping(
			value = "/api/welcomings/{id}",
			method = RequestMethod.DELETE)			
	public ResponseEntity<Welcoming> deleteWelcoming(@PathVariable ("id") Long id){
		welcomingService.delete(id);
		return new ResponseEntity<Welcoming>(HttpStatus.NO_CONTENT);	
		
	}
}
