package com.example.socialApp.dtos.requests.person;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.socialApp.entities.concretes.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatePersonRequest {
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;
	private String email;
	private String phoneNumber;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String bio;
	private Gender gender;
}
