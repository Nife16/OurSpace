package com.space.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="post")
public class Post {
	
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
    
    @Column(name = "content")
	String content;
    
    @Column(name = "dateOfPost")
	Date dateOfPost;

    public Post() {
        super();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateOfPost() {
        return dateOfPost;
    }

    public void setDateOfPost(Date dateOfPost) {
        this.dateOfPost = dateOfPost;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Post [id=" + id + ", content=" + content + ", dateOfPost=" + dateOfPost + "]";
    }

}
