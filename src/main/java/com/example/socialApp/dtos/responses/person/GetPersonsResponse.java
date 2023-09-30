package com.example.socialApp.dtos.responses.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPersonsResponse {
	private Long id;
	private String userName;
	private String firstName;
	private String lastName;
	private String bio;
	
}
