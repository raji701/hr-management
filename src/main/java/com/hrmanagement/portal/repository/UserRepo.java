package com.hrmanagement.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrmanagement.portal.model.User;

public interface UserRepo extends JpaRepository<User,Integer> {

}
