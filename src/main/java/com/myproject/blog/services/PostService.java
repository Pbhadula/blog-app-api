package com.myproject.blog.services;

import java.util.List;

import com.myproject.blog.entities.Post;
import com.myproject.blog.payloads.PostDto;
import com.myproject.blog.payloads.PostResponse;

public interface PostService {
	
	//create
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	//update
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete
	void deletePost(Integer postId);
	
	//get all pots
	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortType);
	
	//get single post
	PostDto getPostById(Integer postId);
	
	// get all post by category
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	//get all posts by user
	List<PostDto> getPostsByUser(Integer userId);
	
	//searchPosts
	List<PostDto> searchPosts(String keyword);
	

}
