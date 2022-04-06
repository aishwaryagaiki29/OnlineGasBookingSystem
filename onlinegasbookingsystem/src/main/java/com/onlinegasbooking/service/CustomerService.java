package com.onlinegasbooking.service;

import java.util.List;

import com.onlinegasbooking.entity.Customer;
import com.onlinegasbooking.exception.CustomerNotFoundException;

/*****
 *          @author          Bhavesh Rathi
 *          Description      It is a customer service - Service class. It provides service 
 *                           methods for adding,updating,deleting,view customer data.
 *          Version          1.0     
 *          Created Date     11 - March - 2021
 ****/

public interface CustomerService {
	public Customer insertCustomer(Customer customer);//aadhar
	public Customer updateCustomer(Customer customer);//exception
	public Customer deleteCustomerById(Integer customerId)throws  CustomerNotFoundException;
	public List<Customer> viewCustomers();//nocustomerexception
}
