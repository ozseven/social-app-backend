package com.example.socialApp.entities.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.socialApp.entities.concretes.enums.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="persons")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true,nullable = false)
	private String email;
	
	@Column(unique =true,nullable=true)
	private String phoneNumber;
	
	@Column(unique = true,nullable = false)
	private String userName;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date createdDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@ElementCollection
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private List<Date> loginDate;
	
	@ElementCollection
	private List<String> mediaUrl;
	
	private String bio;
	
	private Gender gender;
    
	@OneToOne
    private Tag tag;
    
	@OneToMany(mappedBy = "user")
    private List<Comment> comments;
    
	@OneToMany(mappedBy = "user")
    private List<Post> posts;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
