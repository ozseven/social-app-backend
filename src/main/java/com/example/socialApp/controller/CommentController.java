package com.example.socialApp.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.socialApp.business.abstracts.CommentService;
import com.example.socialApp.core.utilities.results.DataResult;
import com.example.socialApp.core.utilities.results.Result;
import com.example.socialApp.dtos.requests.comment.CreateCommentRequest;
import com.example.socialApp.dtos.requests.comment.UpdateCommentRequest;
import com.example.socialApp.dtos.responses.comment.GetByPostIdCommentResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "api/comments")
@AllArgsConstructor
public class CommentController {
	private CommentService commentService;
	
	@PostMapping
	public Result createComment(CreateCommentRequest createCommentRequest) {
		return this.commentService.createComment(createCommentRequest);
	}
	@PatchMapping
	public Result updateComment(UpdateCommentRequest updateCommentRequest) {
		return this.commentService.updateComment(updateCommentRequest);
	}
	@DeleteMapping
	public Result deleteComment(Long id) {
		return this.commentService.deleteCommentById(id);
	}
	@GetMapping
	public DataResult<GetByPostIdCommentResponse> getByPostId(Long id) {
		return this.commentService.getByPostId(id);
	}
}
