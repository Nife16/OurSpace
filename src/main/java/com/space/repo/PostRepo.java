package com.space.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.space.entity.Post;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {

}
