package com.example.socialApp.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.socialApp.business.abstracts.PostService;
import com.example.socialApp.core.utilities.results.Result;
import com.example.socialApp.dtos.requests.post.CreatePostRequest;
import com.example.socialApp.dtos.requests.post.UpdatePostRequest;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping(value = "api/posts")
@RestController
public class PostController {
	private PostService postService;
	
	@PostMapping
	public Result createPost(CreatePostRequest createPostRequest) {
		return this.postService.createPost(createPostRequest);
	}
	@PutMapping
	public Result updatePost(UpdatePostRequest updatePostRequest) {
		return this.postService.updatePost(updatePostRequest);
	}
	@DeleteMapping
	public Result deletePost(Long id) {
		return this.postService.deletePostById(id);
	}
} 
