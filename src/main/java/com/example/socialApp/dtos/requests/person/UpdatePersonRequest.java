package com.example.socialApp.dtos.requests.person;

import com.example.socialApp.entities.concretes.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePersonRequest {
	private Long id;
	private String email;
	private String phoneNumber;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String bio;
	private Gender gender;
}
