package com.space.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.space.entity.Post;
import com.space.entity.User;
import com.space.repo.PostRepo;

@Service
public class PostService {

    @Autowired
    PostRepo postRepo;
    
    @Autowired
    UserService userService;
    
    
    
    // Saving one to many relationships
    public Post save(Post post, Integer userId) {
        
        
        //1) SAVE THE POST
        Post savedPost = postRepo.save(post);
        
        
        // 2) GET THE PARENT OBJECT TO ADD THE POST TO
        User foundUser = userService.getUserById(userId);
        
        
        // 3) ADD POST TO THE PARENT LIST
        foundUser.getPosts().add(savedPost);
        
        
        // 4) SAVE THE PARENT
        userService.save(foundUser);
        
        return savedPost;
        
    }
    
    
}
