package com.onlinegasbooking.service;

import java.util.List;
//import java.util.Map;
import java.util.Optional;

import com.onlinegasbooking.entity.Login;
import com.onlinegasbooking.exception.IdNotFoundException;

public interface LoginService {
	public Login addUser(Login useradd);//exception
	public Optional<Login> getUserById(Integer userId)throws IdNotFoundException;
	public String deleteUserById(Login userId);//exception
	public List<Login> getAllUser();//exception
	
}
