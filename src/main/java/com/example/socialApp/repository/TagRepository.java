package com.example.socialApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.socialApp.entities.concretes.Tag;

public interface TagRepository extends JpaRepository<Tag, Long>{
	Tag findByName(String text);
}
