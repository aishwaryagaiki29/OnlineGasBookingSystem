package com.onlinegasbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.onlinegasbooking.entity.Cylinder;
import com.onlinegasbooking.entity.SurrenderCylinder;
import com.onlinegasbooking.exception.CylinderNotFoundException;
import com.onlinegasbooking.exception.SurrenderCylinderNotFoundException;
import com.onlinegasbooking.repository.CylinderRepository;
import com.onlinegasbooking.service.SurrenderCylinderService;

/*********************************************************************************************
 *          @author          Aishwarya Gaiki
 *          Description      It is a SurrenderCylinder - controller class. It provides 
 *                           RestMappings inorder to connect with the swagger. 
 *          Version          1.0     
 *          Created Date     11 - March - 2021
 **********************************************************************************************/

@CrossOrigin(origins = "http://localhost:3003")
@RestController
public class SurrenderCylinderController {
	@Autowired
	SurrenderCylinderService surrenderCylinderService;
	
	@Autowired
	private CylinderRepository cylinderRepository;

	//add SurrenderCylinder to database
	@PostMapping("/surrendercylinder/{cylid}")
	public SurrenderCylinder addSurrenderCylinder(@RequestBody SurrenderCylinder surrenderCylinder,@PathVariable("cylid") Integer cylid) throws CylinderNotFoundException
	{
		return surrenderCylinderService.addSurrenderCylinder(surrenderCylinder, cylid);
	}
	
	//delete SurrenderCylinder from database
	@DeleteMapping("/surrendercylinder/{surrenderid}")
	public String deleteSurrenderCylinder(SurrenderCylinder surrenderCylinder)
	{
		return surrenderCylinderService.deleteSurrenderCylinder(surrenderCylinder);
	}
	
	//update SurrenderCylinder in database
	@PutMapping("/surrendercylinder")
	public SurrenderCylinder updateSurrenderCylinder(@RequestBody SurrenderCylinder surrenderCylinder)
	{
		return surrenderCylinderService.updateSurrenderCylinder(surrenderCylinder);
	}
	
	@GetMapping("viewallsurrenderedcylinder")
	public List<SurrenderCylinder> viewAllSurrenderedCylinder(){
		return surrenderCylinderService.viewAllSurrenderedCylinder();
	}
}
