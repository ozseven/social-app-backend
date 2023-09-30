package com.example.socialApp.business.abstracts;

import java.util.List;

import com.example.socialApp.core.utilities.results.Result;
import com.example.socialApp.entities.concretes.Post;

public interface TagService {
	public void addTag(List<String> tags);
	public Result deleteTagById(Long id);
}
