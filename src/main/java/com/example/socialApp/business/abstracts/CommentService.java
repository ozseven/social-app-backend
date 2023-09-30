package com.example.socialApp.business.abstracts;

import com.example.socialApp.core.utilities.results.DataResult;
import com.example.socialApp.core.utilities.results.Result;
import com.example.socialApp.dtos.requests.comment.CreateCommentRequest;
import com.example.socialApp.dtos.requests.comment.UpdateCommentRequest;
import com.example.socialApp.dtos.responses.comment.GetByPostIdCommentResponse;
import com.example.socialApp.entities.concretes.Comment;

public interface CommentService {
	public Result createComment(CreateCommentRequest createCommentRequest);
	public Result updateComment(UpdateCommentRequest updateCommentRequest);
	public Result deleteCommentById(Long id);
	public DataResult<GetByPostIdCommentResponse> getByPostId(Long id);
}
