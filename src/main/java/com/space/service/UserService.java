package com.space.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.space.entity.User;

@Service
public class UserService {
	
	int count = 1;
	List<User> accounts = new ArrayList<User>();
	
	
	
	public List<User> getAll() {
	    accounts.clear();
	    User fakeGuy = new User(99, "sally", "sally", "123");
        User fakeGuy1 = new User(100, "sally1", "sally1", "123");
        User fakeGuy2 = new User(101, "sally2", "sally2", "123");
        User fakeGuy3 = new User(102, "sally3", "sally3", "123");
        User fakeGuy4 = new User(103, "sally4", "sally4", "123");
        accounts.add(fakeGuy);
        accounts.add(fakeGuy1);
        accounts.add(fakeGuy2);
        accounts.add(fakeGuy3);
        accounts.add(fakeGuy4);
        
	    return accounts;
	}
	
	public void save(User user) {
		user.setId(count);
		count++;
		accounts.add(user);
	}
    
    public User signIn(User user) {
        accounts.clear();
        
        User fakeGuy = new User(99, "sally", "sally", "123");
        User fakeGuy1 = new User(100, "sally1", "sally1", "123");
        User fakeGuy2 = new User(101, "sally2", "sally2", "123");
        User fakeGuy3 = new User(102, "sally3", "sally3", "123");
        User fakeGuy4 = new User(103, "sally4", "sally4", "123");
        accounts.add(fakeGuy);
        accounts.add(fakeGuy1);
        accounts.add(fakeGuy2);
        accounts.add(fakeGuy3);
        accounts.add(fakeGuy4);
        
        for (User signedUpUser : accounts) {
            
            if(signedUpUser.getUsername().equals(user.getUsername())
                    && signedUpUser.getPassword().equals(user.getPassword())) {
                return signedUpUser;
            }
        }
        
        return null;
    }
    
    public User getUserById(Integer userId) {
        accounts.clear();
        User fakeGuy = new User(99, "sally", "sally", "123");
        User fakeGuy1 = new User(100, "sally1", "sally1", "123");
        User fakeGuy2 = new User(101, "sally2", "sally2", "123");
        User fakeGuy3 = new User(102, "sally3", "sally3", "123");
        User fakeGuy4 = new User(103, "sally4", "sally4", "123");
        accounts.add(fakeGuy);
        accounts.add(fakeGuy1);
        accounts.add(fakeGuy2);
        accounts.add(fakeGuy3);
        accounts.add(fakeGuy4);
        
        for (User signedUpUser : accounts) {
            
            if(signedUpUser.getId().equals(userId)) {
                return signedUpUser;
            }
        }
        
        return null;
    }
	

}
