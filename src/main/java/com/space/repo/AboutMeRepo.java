package com.space.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.space.entity.AboutMe;

@Repository
public interface AboutMeRepo extends JpaRepository<AboutMe, Integer> {

}
