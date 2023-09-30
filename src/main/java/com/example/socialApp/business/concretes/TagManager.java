package com.example.socialApp.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.socialApp.business.abstracts.TagService;
import com.example.socialApp.core.utilities.results.Result;
import com.example.socialApp.entities.concretes.Tag;
import com.example.socialApp.repository.TagRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TagManager implements TagService{
	private TagRepository tagRepository;
	@Override
	public void addTag(List<String> text) {
		for (String string : text) {
			String[] word =string.split(" ");
			for (String string2 : word) {
				if (string2.indexOf("*")==0) {
					if (this.tagRepository.findByName(string2)==null) {
						Tag tag =new Tag();
						tag.setCreatedDate(new Date());
						tag.setName(string2);
						this.tagRepository.save(tag);
					}
				}
			}
		}
		
	}

	@Override
	public Result deleteTagById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
