package com.example.socialApp.dtos.responses.comment;

import com.example.socialApp.entities.concretes.Person;
import com.example.socialApp.entities.concretes.Post;

public class GetAllCommentResponse {
	private Person user;
	private Post post;
	private String text;
}
