package com.onlinegasbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinegasbooking.entity.Login;
@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>{

}
