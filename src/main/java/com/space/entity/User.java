package com.space.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
    
    @Column(name="email", unique = true)
	String email;
    @Column(name="username")
	String username;
    @Column(name="password")
	String password;
    @Column(name="avvy")
	String avvy; // the url the the image
    
//	AboutMe aboutMe;
//	Post[] posts;
	
	public User() {
		super();
	}

	public User(Integer id, String email, String username, String password) {
        super();
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
    }



    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvvy() {
		return avvy;
	}

	public void setAvvy(String avvy) {
		this.avvy = avvy;
	}

//	public AboutMe getAboutMe() {
//		return aboutMe;
//	}
//
//	public void setAboutMe(AboutMe aboutMe) {
//		this.aboutMe = aboutMe;
//	}
//
//	public Post[] getPosts() {
//		return posts;
//	}
//
//	public void setPosts(Post[] posts) {
//		this.posts = posts;
//	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password + ", avvy="
				+ avvy;
	}
	
}