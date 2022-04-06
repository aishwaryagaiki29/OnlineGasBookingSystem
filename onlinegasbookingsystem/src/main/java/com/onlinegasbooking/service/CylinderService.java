package com.onlinegasbooking.service;

import org.springframework.stereotype.Service;

import com.onlinegasbooking.entity.Cylinder;
import com.onlinegasbooking.exception.CustomerNotFoundException;
import com.onlinegasbooking.exception.CylinderNotFoundException;
public interface CylinderService {
	public Cylinder addCylinder(Cylinder cylinder,Integer cid) throws CustomerNotFoundException;
	public Cylinder updateCylinder(Cylinder cylinder)throws CylinderNotFoundException;
	public Cylinder deleteCylinderBYId(Integer cylinderTypeId)throws CylinderNotFoundException;
}
