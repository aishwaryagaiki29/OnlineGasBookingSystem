package com.onlinegasbooking.serviceimplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinegasbooking.entity.Cylinder;
import com.onlinegasbooking.entity.SurrenderCylinder;
import com.onlinegasbooking.exception.CylinderNotFoundException;
import com.onlinegasbooking.repository.CylinderRepository;
import com.onlinegasbooking.repository.SurrenderCylinderRepository;
import com.onlinegasbooking.service.SurrenderCylinderService;
import com.onlinegasbooking.exception.SurrenderCylinderNotFoundException;

/*********************************************************************************************
 *          @author          Aishwarya Gaiki
 *          Description      It is a service class that provides the services for surrendering 
                             a cylinder, fetching surrender cylinder date and Id for a day.         
 *         Version           1.0     
 *         Created Date      08 - March - 2021
 **********************************************************************************************/

@Service
public class SurrenderCylinderServiceImplementation implements SurrenderCylinderService {
     @Autowired 
     private SurrenderCylinderRepository surrenderCylinderRepository;
     
     @Autowired
     private CylinderRepository cylinderRepository;
     
     @Transactional
     public SurrenderCylinder addSurrenderCylinder(SurrenderCylinder surrenderCylinder,Integer cid) throws CylinderNotFoundException
     {
    	 Optional<Cylinder> optionalCylinder = this.cylinderRepository.findById(cid);
 		 if(optionalCylinder.isEmpty())
 			 throw new CylinderNotFoundException("Cylinder not found with Id:"+ cid);
		optionalCylinder.get().setSurrendercylinder(surrenderCylinderRepository.save(surrenderCylinder)); 
 		return cylinderRepository.save(optionalCylinder.get()).getSurrendercylinder();
     }
     
     public SurrenderCylinder updateSurrenderCylinder(SurrenderCylinder surrenderCylinder)
     {
    	 return surrenderCylinderRepository.save(surrenderCylinder);
     }

     public String deleteSurrenderCylinder(SurrenderCylinder surrenderCylinder)
     {
    	 surrenderCylinderRepository.delete(surrenderCylinder);
    	 return "Deleted Successfully!";
     }
     
     @Override
 	public List<SurrenderCylinder> viewAllSurrenderedCylinder(){
           return surrenderCylinderRepository.findAll();
 	}
}
