package com.example.socialApp.business.concretes;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.socialApp.business.abstracts.PersonService;
import com.example.socialApp.core.utilities.mappers.ModelMapperService;
import com.example.socialApp.core.utilities.results.DataResult;
import com.example.socialApp.core.utilities.results.Result;
import com.example.socialApp.core.utilities.results.SuccessDataResult;
import com.example.socialApp.core.utilities.results.SuccessResult;
import com.example.socialApp.dtos.requests.person.CreatePersonRequest;
import com.example.socialApp.dtos.requests.person.UpdatePersonRequest;
import com.example.socialApp.dtos.responses.person.GetPersonsResponse;
import com.example.socialApp.entities.concretes.Person;
import com.example.socialApp.repository.PersonRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonManager implements PersonService{
	private ModelMapperService modelMapperService;
	private PersonRepository personRepository;
	
	@Override
	public Result createPerson(CreatePersonRequest createPersonRequest) {
		Person person =this.modelMapperService.forRequest().map(createPersonRequest, Person.class);
		Date createdDate =new Date();
		person.setCreatedDate(createdDate);
		this.personRepository.save(person);
		return new SuccessResult("person created");
	}

	@Override
	public Result updatePerson(UpdatePersonRequest updatePersonRequest) {
		Person person =this.personRepository.findById(updatePersonRequest.getId()).orElseThrow();
		person.setEmail(updatePersonRequest.getEmail());
		person.setPhoneNumber(updatePersonRequest.getPhoneNumber());
		person.setUserName(updatePersonRequest.getUserName());
		person.setPassword(updatePersonRequest.getPassword());
		person.setFirstName(updatePersonRequest.getFirstName());
		person.setFirstName(updatePersonRequest.getFirstName());
		person.setBio(updatePersonRequest.getBio());
		person.setGender(updatePersonRequest.getGender());

		this.personRepository.save(person);
		return new Result("The person is updated.");
	}
	
	
	


	@Override
	public Result deletePersonById(Long id) {
		this.personRepository.deleteById(id);
		return new SuccessResult("The person is deleted.");
	}

	@Override
	public DataResult<List<GetPersonsResponse>> getAllPersons() {
		List<Person> persons = this.personRepository.findAll();
		List<GetPersonsResponse> getPersonsResponses =persons.stream().map(person -> this.modelMapperService.forResponse().map(person, GetPersonsResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<GetPersonsResponse>>(getPersonsResponses, "Persons listed.");
	}
	


	@Override
	public DataResult<GetPersonsResponse> getPersonById(Long id) {
		Person person =this.personRepository.findById(id).orElseThrow();
		GetPersonsResponse getPersonResponse =this.modelMapperService.forResponse().map(person, GetPersonsResponse.class);
		return new SuccessDataResult<GetPersonsResponse>(getPersonResponse,"The person listed.");
	}

}





















