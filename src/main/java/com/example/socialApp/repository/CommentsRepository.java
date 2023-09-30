package com.example.socialApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.socialApp.entities.concretes.Comment;

public interface CommentsRepository extends JpaRepository<Comment, Long>{
	Comment findByPostId(Long id);
}
