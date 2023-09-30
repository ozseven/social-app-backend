package com.example.socialApp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.socialApp.business.abstracts.PersonService;
import com.example.socialApp.core.utilities.results.DataResult;
import com.example.socialApp.core.utilities.results.Result;
import com.example.socialApp.dtos.requests.person.CreatePersonRequest;
import com.example.socialApp.dtos.requests.person.UpdatePersonRequest;
import com.example.socialApp.dtos.responses.person.GetPersonsResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "api/persons")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {
	private PersonService personService;
	
	@PostMapping
	public Result createPerson(CreatePersonRequest createPersonRequest) {
		return this.personService.createPerson(createPersonRequest);
	}
	@PutMapping
	public Result updatePerson(UpdatePersonRequest updatePersonRequest) {
		return this.personService.updatePerson(updatePersonRequest);
	}
	@DeleteMapping
	public Result deletePerson(Long id) {
		return this.personService.deletePersonById(id);
	}
	@GetMapping
	public DataResult<List<GetPersonsResponse>> getAllPersons(){
		return this.personService.getAllPersons();
	}
	@GetMapping(path = "/{id}")
	public DataResult<GetPersonsResponse> getPersonById(@PathVariable("id") Long id) {
		return this.personService.getPersonById(id);
	}
	
}
