package com.space.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.space.service.AboutMeService;
import com.space.service.PostService;

@RestController
@RequestMapping(value = "/post")
public class AboutMeRestController {

    @Autowired
    AboutMeService aboutMeService;
    
    
    
}
