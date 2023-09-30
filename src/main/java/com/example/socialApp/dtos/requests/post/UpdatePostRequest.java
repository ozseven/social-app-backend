package com.example.socialApp.dtos.requests.post;

import java.util.List;

import com.example.socialApp.entities.concretes.Tag;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePostRequest {
	private Long id;
	private List<Long> tagId;
	private List<String> mediaUrl;
	private List<String> title;
	private List<String> text;
}
