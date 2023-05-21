package com.myproject.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
