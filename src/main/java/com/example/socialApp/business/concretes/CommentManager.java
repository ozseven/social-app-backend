package com.example.socialApp.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.socialApp.business.abstracts.CommentService;
import com.example.socialApp.core.utilities.mappers.ModelMapperManager;
import com.example.socialApp.core.utilities.results.DataResult;
import com.example.socialApp.core.utilities.results.Result;
import com.example.socialApp.core.utilities.results.SuccessDataResult;
import com.example.socialApp.core.utilities.results.SuccessResult;
import com.example.socialApp.dtos.requests.comment.CreateCommentRequest;
import com.example.socialApp.dtos.requests.comment.UpdateCommentRequest;
import com.example.socialApp.dtos.responses.comment.GetByPostIdCommentResponse;
import com.example.socialApp.entities.concretes.Comment;
import com.example.socialApp.entities.concretes.Post;
import com.example.socialApp.repository.CommentsRepository;
import com.example.socialApp.repository.PostRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CommentManager implements CommentService{
	private CommentsRepository commentsRepository;
	private ModelMapperManager modelMapperManager;
	private PostRepository postRepository;
	
	@Override
	public Result createComment(CreateCommentRequest createCommentRequest) {
		Post post =this.postRepository.findById(createCommentRequest.getPostId()).orElseThrow();
		Comment comment =this.modelMapperManager.forRequest().map(createCommentRequest, Comment.class);
		Date date =new Date();
		comment.setCreatedDate(date);
		comment.setPost(post);
		this.commentsRepository.save(comment);
		return new SuccessResult("Comment is created");
	}

	@Override
	public Result updateComment(UpdateCommentRequest updateCommentRequest) {
		Comment comment =this.commentsRepository.findById(updateCommentRequest.getId()).orElseThrow();
		Date date =new Date();
		comment.setText(updateCommentRequest.getText());
		comment.setUpdatedDate(date);
		this.commentsRepository.save(comment);
		return new SuccessResult("Comment is updated");
	}

	@Override
	public Result deleteCommentById(Long id) {
		this.commentsRepository.deleteById(id);
		return new SuccessResult("Comment is deleted.");
	}
	public DataResult<GetByPostIdCommentResponse> getByPostId(Long postId){
		Comment comment=this.commentsRepository.findByPostId(postId);
		GetByPostIdCommentResponse commentResponse =this.modelMapperManager.forResponse().map(comment, GetByPostIdCommentResponse.class);
		return new SuccessDataResult<GetByPostIdCommentResponse>(commentResponse); 
	}

}
