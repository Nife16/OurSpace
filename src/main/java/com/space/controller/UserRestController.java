package com.space.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.space.entity.User;
import com.space.service.UserService;

@RestController
public class UserRestController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/signUp", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<Object> signUp(@RequestBody User user) {
        try {
            User signedInUser = userService.save(user);
    
            return new ResponseEntity<>(signedInUser, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        } catch(Error e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/signIn", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<Object> signIn(@RequestBody User user) {

        try {
            User signedInUser = userService.signIn(user);
            
            if(signedInUser == null) {
                
                throw new Error("No user found");
                
            }
    
            return new ResponseEntity<>(signedInUser, HttpStatus.OK);
            
        } catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch(Error e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
