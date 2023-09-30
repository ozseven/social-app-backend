package com.example.socialApp.business.concretes;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.socialApp.business.abstracts.PostService;
import com.example.socialApp.business.abstracts.TagService;
import com.example.socialApp.core.utilities.mappers.ModelMapperManager;
import com.example.socialApp.core.utilities.results.Result;
import com.example.socialApp.core.utilities.results.SuccessResult;
import com.example.socialApp.dtos.requests.post.CreatePostRequest;
import com.example.socialApp.dtos.requests.post.UpdatePostRequest;
import com.example.socialApp.entities.concretes.Post;
import com.example.socialApp.repository.PostRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostManager implements PostService{
	private ModelMapperManager modelMapperManager;
	private PostRepository postRepository;
	private TagService tagService;
	
	@Override
	public Result createPost(CreatePostRequest createPostRequest) {
		Post post =this.modelMapperManager.forRequest().map(createPostRequest, Post.class);
		Date date =new Date();
		post.setCreatedDate(date);
		this.tagService.addTag(createPostRequest.getText());
		this.postRepository.save(post);
		return new SuccessResult("Post added.");
	}

	@Override
	public Result updatePost(UpdatePostRequest updatePostRequest) {
		Post oldPost = this.postRepository.findById(updatePostRequest.getId()).orElseThrow();
		Post post =this.modelMapperManager.forRequest().map(updatePostRequest, Post.class);
		
		Date date =new Date();
		post.setUpdatedDate(date);
		post.setCreatedDate(oldPost.getCreatedDate());

		return new SuccessResult("Post updated.");
	}

	@Override
	public Result deletePostById(Long id) {
		this.postRepository.deleteById(id);
		return new SuccessResult("Post is deleted");
	}

}
