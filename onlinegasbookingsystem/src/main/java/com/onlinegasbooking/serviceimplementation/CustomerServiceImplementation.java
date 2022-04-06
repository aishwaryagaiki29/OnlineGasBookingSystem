package com.onlinegasbooking.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinegasbooking.entity.Customer;
import com.onlinegasbooking.exception.CustomerNotFoundException;
import com.onlinegasbooking.repository.CustomerRepository;
import com.onlinegasbooking.service.CustomerService;
import com.onlinegasbooking.exception.CustomerNotFoundException;

/*****
 *          @author          Bhavesh Rathi
 *          Description      It is a service class that provides the services for 
 *          				 customer .         
 *         Version           1.0     
 *         Created Date      08 - March - 2021
 ****/

@Service
public class CustomerServiceImplementation implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	/****
 	 *  Method : insertCustomer
 	 *  Description : To insert the customer.
 	 *  			  Used inbuilt save() method to add customer .
 	 *  @param insertcustomer : customer which is added.
 	 *
 	 *Created date : 11/03/2022
*****/
	public Customer insertCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	/****
 	 *  Method : updateCustomer
 	 *  Description : To update the customer .
 	 *  			  Used inbuilt save() method to update customer .
 	 *  @param updateCustomer : customer which should be update.
 	 *
 	 *Created date : 11/03/2022
*****/
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	/****
 	 *  Method : deleteCustomerById
 	 *  Description : To delete the customer by id .
 	 *  			  Used inbuilt findById method to find  customer .
 	 *  @param deleteCustomerById : customer which should be update.
 	 *
 	 *Created date : 11/03/2022
*****/
	
	public Customer deleteCustomerById(Integer customerId) throws CustomerNotFoundException {

		Customer customer = customerRepository.findById(customerId).get();
		if(customer==null)
			throw new CustomerNotFoundException("Customer not found with Id:"+" "+customerId);
		customerRepository.delete(customer);
		return customer;
	}

	/****
 	 *  Method : viewCustomer
 	 *  Description : To view the customer  .
 	 *  			  Used inbuilt findById method to find  customer .
 	 *  @param viewCustomer : customer which we want see.
 	 *
 	 *Created date : 11/03/2022
*****/
	public List<Customer> viewCustomers() {
		return customerRepository.findAll();	
	}

}
