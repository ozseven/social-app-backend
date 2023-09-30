package com.example.socialApp.entities.concretes;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="posts")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Person user;
	@OneToMany(mappedBy = "post")
	private List<Tag> tag;
	private List<String> mediaUrl;
	private List<String> title;
	private List<String> text;
	private Date createdDate;
	private Date updatedDate;
	@OneToMany(mappedBy = "post")
	private List<Comment> comment;
}