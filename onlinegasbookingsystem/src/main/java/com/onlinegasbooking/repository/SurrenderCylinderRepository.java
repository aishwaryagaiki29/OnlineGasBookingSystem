package com.onlinegasbooking.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinegasbooking.entity.SurrenderCylinder;

/*********************************************************************************************
 *          @author          Aishwarya Gaiki
 *          Description      It is a repository class that provides the JPA Repository for   
 *                           SurrenderCylinder.      
 *         Version           1.0     
 *         Created Date      08 - March - 2021
 **********************************************************************************************/

@Repository
public interface SurrenderCylinderRepository extends JpaRepository<SurrenderCylinder, Integer>{
	
}
