package com.onlinegasbooking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinegasbooking.entity.Customer;
import com.onlinegasbooking.entity.GasBooking;
import com.onlinegasbooking.exception.GasBookingIdNotFound;
import com.onlinegasbooking.repository.CustomerRepository;
import com.onlinegasbooking.repository.GasBookingRepository;
import com.onlinegasbooking.service.GasBookingService;

/*******************************
 *          @author: Vaishnavi Patil       
 *          @version: 1.0   
 *          Description: It is a GasBooking controller class that provides RestMappings inorder to 
 *          connect with the swagger
 *          			                           
 *          Created at: 16-March-2022
 ********************************/

@RestController
public class GasBookingController {

	@Autowired
	private GasBookingService gasBookingService;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/customer/{custid}")
	public Customer getCustomer(@PathVariable("custid") Integer custid ) {
		return customerRepository.findById(custid).get();
	}
	
	//Add a gasbooking to database
	@PostMapping("/gasbooking") 
	public GasBooking insertGasBooking(@Valid @RequestBody GasBooking gasbooking) {
		return gasBookingService.insertGasBooking(gasbooking);
	}
	
	//Update the details of gasbooking if required
	@PutMapping("/gasbooking")
	public GasBooking updateGasBooking(@Valid @RequestBody GasBooking gasbooking) {
		return gasBookingService.updateGasBooking(gasbooking);
	}
	
	//delete the gasbookingId from DB
	@DeleteMapping("/gasbooking/{gasbookingid}")
	public GasBooking deleteGasBookingById(@PathVariable("gasbookingid") Integer gasBookingId) throws GasBookingIdNotFound {
		return gasBookingService.deleteGasBookingById(gasBookingId);
	}
}
