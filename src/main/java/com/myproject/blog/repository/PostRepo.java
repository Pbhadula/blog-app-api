package com.myproject.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.blog.entities.Category;
import com.myproject.blog.entities.Post;
import com.myproject.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	//custom finder methods
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	List<Post> findByTitleContaining(String title);

}
