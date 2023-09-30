package com.example.socialApp.dtos.requests.post;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostRequest {
	private List<String> mediaUrl;
	private List<String> title;
	private List<String> text;
}
