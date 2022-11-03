package com.space.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.space.entity.User;
import com.space.repo.UserRepo;

@Service
public class UserService {
	
    
    @Autowired
    UserRepo userRepo;
    
	int count = 1;
	List<User> accounts = new ArrayList<User>();
	
	
	
	public List<User> getAll() {
	    
	    return userRepo.findAll();
	}
	
	public User save(User user) {
	    return userRepo.save(user);
	}
    
    public User signIn(User user) {
        
        
        return userRepo.signIn(user.getEmail(), user.getPassword());

       
    }
    
    public User getUserById(Integer userId) {
        
        if(userRepo.findById(userId).isPresent()) {
            return userRepo.findById(userId).get();
        }
        
        throw new Error("User not found");
        
    }
    
    public User getUserByEmail(String email) {
        
        User foundUser = userRepo.getByEmail(email);
        
        if(foundUser == null) {
           throw new Error("User not found");
        }
        
        return foundUser;
        
    }
	

}
