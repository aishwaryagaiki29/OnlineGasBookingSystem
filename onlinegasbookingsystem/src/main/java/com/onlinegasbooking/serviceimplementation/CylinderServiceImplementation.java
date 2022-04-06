package com.onlinegasbooking.serviceimplementation;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinegasbooking.entity.Customer;
import com.onlinegasbooking.entity.Cylinder;
import com.onlinegasbooking.exception.CustomerNotFoundException;
import com.onlinegasbooking.exception.CylinderNotFoundException;
import com.onlinegasbooking.repository.CustomerRepository;
import com.onlinegasbooking.repository.CylinderRepository;
import com.onlinegasbooking.repository.SurrenderCylinderRepository;
import com.onlinegasbooking.service.CylinderService;
/****************************
 * @author Sakshi Gondole
 * Description: It is a service implementation class that provides the services for adding new Cylinder, updating
                new Cylinder, deleting Cylinder record as well as
                displaying the Cylinder by it's Id. 
 * Version: 1.0 
 * Created Date :08 March 2022
 ****************************/
@Service
public class CylinderServiceImplementation implements CylinderService{
	@Autowired
	private CylinderRepository cylinderRepository;
	
	@Autowired
	public CustomerRepository customerRespository;
	
	@Autowired
	public SurrenderCylinderRepository surrenderCylinderRepository;
	
	/*************************
	 * Method: addCylinder
	 *  Description: To add new Cylinder
	 * @param center - Cylinder  details
	 * @returns Cylinder- newly added Cylinder record. 
	 * By -Sakshi Gondole
	 * Created Date - 08 March 2022
	 *************************/
	@Transactional
	public Cylinder addCylinder (Cylinder cylinder,Integer cid) throws CustomerNotFoundException{
		
		Optional<Customer> optionalCustomer = this.customerRespository.findById(cid);
		if(optionalCustomer.isEmpty())
			throw new CustomerNotFoundException("Customer not found with Id:"+cid);
		
		optionalCustomer.get().setCylinder(cylinderRepository.save(cylinder)); 
		return customerRespository.save(optionalCustomer.get()).getCylinder();
	}
	
	/****************************
	 * Method: updateCylinder
	 *  Description: To update the Cylinder
	 * @param center - Cylinder details
	 * @returns -Cylinder newly updated Cylinder record.
	 *  By -Sakshi Gondole 
	 *  Created Date - 08 March 2022
	******************************/
	public Cylinder updateCylinder(Cylinder cylinder) throws CylinderNotFoundException{
		
		Optional<Cylinder> optionalCylinder = this.cylinderRepository.findById(cylinder.getCylinderTypeId());
		if(optionalCylinder.isEmpty())
			throw new CylinderNotFoundException("Cylinder not found with id:"+ cylinder.getCylinderTypeId());{
		return  cylinderRepository.getById(cylinder.getCylinderTypeId());
			}
	}
	/************************
	 * Method: deleteCylinder
	 * Description: To delete the Cylinder
	 * @returns String: Cylinder deleted successfully
	 * By - Sakshi Gondole
	 * Created Date - 08 March 2022
	*************************/
	public Cylinder deleteCylinder(Integer cylinderTypeId) {
		return null;
		
	}
	
	public Cylinder deleteCylinderBYId(Integer cylinderTypeId) throws CylinderNotFoundException{
		
		Optional<Cylinder> optionalCylinder = cylinderRepository.findById(cylinderTypeId);
		if(optionalCylinder.isEmpty())
			throw new CylinderNotFoundException("Cylinder not found with id:"+cylinderTypeId);
		Customer customer = optionalCylinder.get().getCustomer();
		customer.setCylinder(null);
		customerRespository.save(customer);
		cylinderRepository.delete(optionalCylinder.get());
		return optionalCylinder.get();
	}

	
}
