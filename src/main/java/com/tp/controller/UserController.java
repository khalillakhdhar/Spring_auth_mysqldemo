package com.tp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tp.model.User;
import com.tp.repository.UserRepository;

@RestController
public class UserController {
	
	
	@GetMapping("hello")
	public String hi()
	{
	return "hi";	
	}
	   

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping("/")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") Long id) {
        return userRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@Valid @RequestBody User user) {
user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
       return userRepository.save(user);
    }


}