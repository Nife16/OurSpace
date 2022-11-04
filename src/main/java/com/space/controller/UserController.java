package com.space.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.space.entity.User;
import com.space.service.UserService;

// Annotates the class to being a Spring bean Controller
@Controller
public class UserController {
	
	// Autowired Instantiates/Initializes the UserService bean to this class
	@Autowired
	UserService userService;
	
	// Get Mappings for when you first go to a page, like clicking the home button, or some anchor tag
	// The ("") should contain the url that is actually shown in the browser
	@GetMapping("/")
	public String index() {
		
		// Return the name of the JSP page you would like to show, name is case sensitive
		return "home";
		
	}
	
	// Get Mappings for when you first go to a page, like clicking the home button, or some anchor tag
	@GetMapping("/sign-up")
	public String signUp(Model model) {
		
		// Model attributes are putting data data on the JSP
		// Like for setting up forms in this case
		// Or for showing object data on pages, if the object were already existing
		model.addAttribute("user", new User());
		
		// Return the name of the JSP page you would like to show, name is case sensitive
		return "sign-up";
		
	}
	
	// Post mappings are for when you are accepting information from a page, like from forms
	@PostMapping("/sign-up")
	// Model attribute is the data you have accepted from the form in the user object
	public ModelAndView signUp(@ModelAttribute User user, Model model) {
		
		// I can use my userService bean to save the model user from the form
		userService.save(user);
		
		// Return to the signin page so they can re-verify themself
		// The ModelAndView is a object for syntactically returning a new model and view
		// You can still just return a string, make sure you add your stuff to the model like above
		return new ModelAndView("sign-in", "user", new User());
		
	}
	
	// Works the same as sign-up
	@GetMapping("/sign-in")
	public String signIn(Model model) {
		
		model.addAttribute("user", new User());
		
		return "sign-in";
		
	}
	
	// Works the same as sign-up
	@PostMapping("/sign-in")
	// The HTttpSession is an object for storing user data across pages and they navigate the site
	// Your model gets refreshed every new page, your session keeps its state until you close the site
	public String signIn(@ModelAttribute User user, Model model, HttpSession session) {
		
		// Go verify user with email and password
		User loggedInUser = userService.signIn(user);
		
		// If the user is null, then they are assumed not found, so should not be signed in
		if(loggedInUser == null) {
			return "sign-in";
		}
		
		
		// If not, set the next page up to be shown
		// Add user to session, so you can continually get user from there in other pages
		model.addAttribute("user", loggedInUser);
		session.setAttribute("user", loggedInUser);
		
		return "home";
		
	}
	

    
	// Path Variables are passed in url in browser, use {} to denote them in your code
    @GetMapping("/profile/{userId}")
    // @PathVariable says we are going to have some value in our url we need to do logic
    public String profile(Model model, @PathVariable Integer userId, HttpSession session) {
        
    	User loggedInUser = (User) session.getAttribute("user");
    	
    	
    	// Validate that user was found either on the session, or can be found with a @PathVariable userId
    	// If user cant be found, return sign-in so they can validate properly
        if(userId == null && loggedInUser == null) {
            return "sign-in";
        } else if(userId != null && loggedInUser == null) {
        	loggedInUser = userService.getUserById(userId);
        }
        
        if(loggedInUser == null) {
            return "sign-in";
        }
        
        // If user is found, set up page to show data
        
        model.addAttribute("user", loggedInUser);
        
        
        return "profile";
        
    }
    
    @GetMapping("/viewAll")
    public String viewAll(Model model, HttpSession session) {
        
        
        List<User> userList = userService.getAll();
        
        
        model.addAttribute("userList", userList);
        
        return "list";
        
    }
	

}
