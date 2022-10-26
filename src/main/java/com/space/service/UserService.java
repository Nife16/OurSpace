package com.space.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.space.entity.User;

@Service
public class UserService {
	
	int count = 1;
	List<User> accounts = new ArrayList<User>();
	
	public void save(User user) {
		user.setId(count);
		count++;
		accounts.add(user);
	}
	
	public User signIn(User user) {
		
		for (User signedUpUser : accounts) {
			
			if(signedUpUser.getUsername().equals(user.getUsername())
					&& signedUpUser.getPassword().equals(user.getPassword())) {
				return signedUpUser;
			}
		}
		
		return null;
	}
	

}
