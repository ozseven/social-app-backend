package com.example.socialApp.business.abstracts;

import org.springframework.web.bind.annotation.RestController;

import com.example.socialApp.core.utilities.results.Result;
import com.example.socialApp.dtos.requests.post.CreatePostRequest;
import com.example.socialApp.dtos.requests.post.UpdatePostRequest;

@RestController("api/posts")
public interface PostService {
	public Result createPost(CreatePostRequest createPostRequest);
	public Result updatePost(UpdatePostRequest updatePostRequest);
	public Result deletePostById(Long id);
}
