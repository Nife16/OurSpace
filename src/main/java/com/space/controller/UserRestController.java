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

// The rest controller denotes you will be spitting data out to a seperate front end client
// No longer spitting out to JSP's
@RestController
// The request mapping here gives me controller a dedicated url, so i can use endpoint in other controllers
@RequestMapping(value="/user")
public class UserRestController {

	// Brings in UserService bean to class
    @Autowired
    UserService userService;

    // Configures my endpoint, /signup in the end url, accepts JSON data, Produces JSON data, accessed with a post
    @RequestMapping(
    		value = "/signUp",
    		consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE,
    		method = RequestMethod.POST
    		)
    // We return a ResponseEntity<Object> because the object returned may vary, could be user, could be an error
    // The RequestBody is the information sent to us to process, post and put has request body, get and delete do not
    // Request body is encrypted, always send password through a post request
    public ResponseEntity<Object> signUp(@RequestBody User user) {
    	// Wrap your endpoints in a try catch, if an error happens at any points, you return that error to the client
        try {
            User signedInUser = userService.save(user);
    
            // Give proper status codes, OK 200, BadRequest 400, INTERNAL_SERVER_ERROR 500
            return new ResponseEntity<>(signedInUser, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        } catch(Error e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/signIn",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST
            )
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
    
    // Path variables can be sent here too, same way with {} to say where they will be
    @RequestMapping(
            value="/getByEmail/{email}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET
            )
    // Grab the path variable same way as before, with annotation @PathVariable
    public ResponseEntity<Object> getUserByEmail(@PathVariable String email) {
        
        try {
            User foundUser = userService.getUserByEmail(email);
            
            return new ResponseEntity<>(foundUser, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        } catch (Error e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
