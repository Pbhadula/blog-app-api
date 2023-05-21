package com.myproject.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.blog.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Integer>{

}
