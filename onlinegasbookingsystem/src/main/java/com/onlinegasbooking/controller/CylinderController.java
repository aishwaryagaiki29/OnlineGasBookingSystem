package com.onlinegasbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinegasbooking.entity.Customer;
import com.onlinegasbooking.entity.Cylinder;
import com.onlinegasbooking.exception.CustomerNotFoundException;
import com.onlinegasbooking.exception.CylinderNotFoundException;
import com.onlinegasbooking.repository.CustomerRepository;
import com.onlinegasbooking.repository.SurrenderCylinderRepository;
import com.onlinegasbooking.service.CylinderService;


/****************************
 * @author Sakshi Gondole
 * Description It is a Cylinder-controller class that provides RestMappings inorder to connect with the swagger.
 * Version 1.0 
 * Created Date 11 March 2022
 ****************************/

@RestController
public class CylinderController {
	@Autowired
	private CylinderService cylinderService;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	public SurrenderCylinderRepository surrenderCylinderRepository;

	@PostMapping("/cylinder/{custid}")
	public Cylinder addCylinder(@RequestBody Cylinder cylinder, @PathVariable("custid") Integer cId) throws CustomerNotFoundException{
		return cylinderService.addCylinder(cylinder,cId);
	}

	@PutMapping("/cylinder")
	public Cylinder update(@RequestBody Cylinder cylinder) throws CylinderNotFoundException{
		return cylinderService.updateCylinder(cylinder);
	}

	@DeleteMapping("/cylinder/{cylindertypeid}")
	public Cylinder deleteCylinder(@PathVariable("cylindertypeid") Integer cylinderTypeId) throws CylinderNotFoundException{
		return cylinderService.deleteCylinderBYId(cylinderTypeId);
	}
}
