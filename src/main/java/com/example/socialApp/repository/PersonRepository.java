package com.example.socialApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.socialApp.entities.concretes.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
