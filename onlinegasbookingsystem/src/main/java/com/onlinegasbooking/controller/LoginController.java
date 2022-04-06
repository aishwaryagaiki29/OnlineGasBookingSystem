package com.onlinegasbooking.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinegasbooking.entity.Login;
import com.onlinegasbooking.exception.IdNotFoundException;
import com.onlinegasbooking.service.LoginService;

/***********************
 * Description : This is Controller for Login
 *               This class helps to handle incoming browser requests , 
 *               retrieves necessary model data and returns appropriate 
 *               responses
 * 
 ************************ */

@RestController
public class LoginController {
	@Autowired
	private LoginService loginService;

	//Add user to database
	@PostMapping("/login")
	public Login addUser(@Valid @RequestBody Login useradd) {
		return loginService.addUser(useradd);
	}

	//get user from database
	@GetMapping("/login/{userId}")
	public Optional<Login> getUserById(@Valid @PathVariable Integer userId) throws IdNotFoundException {
		return loginService.getUserById(userId);
	}

	//delete user from database
	@DeleteMapping("/login")
	public String deleteUserById(@RequestBody Login userId) {
		return loginService.deleteUserById(userId);
	}
}
