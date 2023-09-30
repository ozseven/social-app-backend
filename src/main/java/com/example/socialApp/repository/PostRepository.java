package com.example.socialApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.socialApp.entities.concretes.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
