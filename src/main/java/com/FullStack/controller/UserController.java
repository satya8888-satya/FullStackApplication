package com.FullStack.controller;

import java.util.*;
import com.FullStack.exceptions.CustomExceptions;
import com.FullStack.exceptions.UserNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FullStack.model.New_User;
import com.FullStack.repository.UserRepo;

import jakarta.persistence.GeneratedValue;

@RestController
public class UserController {
@Autowired
private UserRepo repo;
@PostMapping("/addNewUser")
New_User user(@RequestBody New_User user) {
	return repo.save(user);
}
@GetMapping("/getUsers")
List<New_User> getAllUsers(){
	return (List<New_User>) repo.findAll();
}
@PutMapping("/user/{id}")
New_User updateUser(@RequestBody New_User user, @PathVariable Long id) {
    return repo.findById(id)
            .map(New_User -> {
                user.setUsername(user.getUsername());
                user.setName(user.getName());
                user.setEmail(user.getEmail());
                return repo.save(user);
            }).orElseThrow(() -> new UserNotFoundException(id));
}

@DeleteMapping("/user/{id}")
String deleteUser(@PathVariable Long id){
    if(!repo.existsById(id)){
        throw new UserNotFoundException(id);
    }
    repo.deleteById(id);
    return  "User with id "+id+" has been deleted success.";
}

}
