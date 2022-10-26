package com.space.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.space.entity.User;
import com.space.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String index() {
		
		return "home";
		
	}
	
	@GetMapping("/sign-up")
	public String signUp(Model model) {
		
		model.addAttribute("user", new User());
		return "sign-up";
		
	}
	
	@PostMapping("/sign-up")
	public ModelAndView signUp(@ModelAttribute User user, Model model) {
		
		userService.save(user);
		
		
		return new ModelAndView("sign-in", "user", new User());
		
	}
	
	@GetMapping("/sign-in")
	public String signIn(Model model) {
		
		model.addAttribute("user", new User());
		
		return "sign-in";
		
	}
	
	@PostMapping("/sign-in")
	public String signIn(@ModelAttribute User user, Model model) {
		
		User loggedInUser = userService.signIn(user);
		
		if(loggedInUser == null) {
			return "sign-in";
		}
		
		model.addAttribute("user", loggedInUser);
		
		return "home";
		
	}
	

}
