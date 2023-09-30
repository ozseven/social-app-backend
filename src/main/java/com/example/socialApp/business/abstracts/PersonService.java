package com.example.socialApp.business.abstracts;

import java.util.List;

import com.example.socialApp.core.utilities.results.DataResult;
import com.example.socialApp.core.utilities.results.Result;
import com.example.socialApp.dtos.requests.person.CreatePersonRequest;
import com.example.socialApp.dtos.requests.person.UpdatePersonRequest;
import com.example.socialApp.dtos.responses.person.GetPersonsResponse;

public interface PersonService {
	public Result createPerson(CreatePersonRequest createPersonRequest);
	public Result updatePerson(UpdatePersonRequest updatePersonRequest);
	public Result deletePersonById(Long id);
	
	public DataResult<List<GetPersonsResponse>> getAllPersons();
	public DataResult<GetPersonsResponse> getPersonById(Long id);
}
