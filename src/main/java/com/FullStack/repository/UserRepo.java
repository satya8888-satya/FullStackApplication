package com.FullStack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FullStack.model.New_User;

public interface UserRepo extends JpaRepository<New_User, Long>{

}
