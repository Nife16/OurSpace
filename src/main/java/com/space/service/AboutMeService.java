package com.space.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.space.repo.AboutMeRepo;

@Service
public class AboutMeService {

    @Autowired
    AboutMeRepo aboutMeRepo;
    
}
