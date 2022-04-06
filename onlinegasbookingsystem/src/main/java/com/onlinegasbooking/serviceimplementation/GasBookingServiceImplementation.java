package com.onlinegasbooking.serviceimplementation;

import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service; 
import com.onlinegasbooking.service.GasBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import com.onlinegasbooking.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinegasbooking.entity.Customer;
import com.onlinegasbooking.entity.GasBooking;
import com.onlinegasbooking.exception.GasBookingIdNotFound;
import com.onlinegasbooking.repository.GasBookingRepository;
import com.onlinegasbooking.repository.CustomerRepository;

/*******************************
 *          @author: Vaishnavi Patil       
 *          @version: 1.0   
 *          Description: It is a service class that provides the services for booking a cylinder,
 *          			  generate invoice, update status of gas booking and get all invoices                            
 *          Created at: 16-March-2022
 ********************************/

@Service
public class GasBookingServiceImplementation implements GasBookingService{

	@Autowired
	private GasBookingRepository gasBookingRepository;

	@Autowired
	public CustomerRepository customerRespository;

	/*********
	 *  Method : insertGasBooking
	 *  Description: To add the gasbooking by giving id as input.
	 *  			  Used inbuilt save() method to add gasbooking.
	 *  @param cid : id at which category want to find
	 *
	 *Created date : 11/03/2022
	 *********/
	public GasBooking insertGasBooking(GasBooking gasBooking)
	{
		return gasBookingRepository.save(gasBooking);
	}
	
	/*********
	 *  Method :updateGasbookinggetCategory
	 *  Description : To update the gasbooking if required. Used 
	 *  inbuilt method save() to update gas booking
	 *  @param cid : id at which category want to find
	 *
	 *Created date : 11/03/2022
	 *********/
	public GasBooking updateGasBooking(GasBooking gasBooking)
	{   
		Optional<GasBooking> optionalgasBooking = this.gasBookingRepository.findById(gasBooking.getGasbookingId());
		GasBooking modifiedgasBooking = optionalgasBooking.get();
		modifiedgasBooking.setBill(gasBooking.getBill());
		return gasBookingRepository.save(modifiedgasBooking);
	}
	
	/*********
	 *  Method :calculateBill
	 *  Description : To calculate the gasbooking bill used
	 *  inbuilt method save()
	 *  @param cid : id at which category want to find
	 *
	 *Created date : 11/03/2022
	 *********/

	/*********
	 *  Method :deleteGasbooking
	 *  Description : To delete the gasbooking by gasbookingId
	 *  @param cid : id at which category want to find
	 *
	 *Created date : 11/03/2022
	 *********/
	
	public GasBooking deleteGasBookingById(Integer gasBookingId) throws GasBookingIdNotFound {
		Optional<GasBooking> optionalGasBooking = gasBookingRepository.findById(gasBookingId);
		if(optionalGasBooking.isEmpty())
			throw new GasBookingIdNotFound("GasBooking Id not found with Id:"+" "+gasBookingId);
		else
		gasBookingRepository.delete(optionalGasBooking.get());
		return optionalGasBooking.get();
	}
}
