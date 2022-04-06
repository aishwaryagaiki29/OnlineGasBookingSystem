package com.onlinegasbooking.controller;

import java.util.List;
import java.util.Optional;

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
import com.onlinegasbooking.entity.Cylinder;
import com.onlinegasbooking.service.CustomerService;
import com.onlinegasbooking.exception.CustomerNotFoundException;
import com.onlinegasbooking.exception.CylinderNotFoundException;
import com.onlinegasbooking.repository.CustomerRepository;
import com.onlinegasbooking.exception.CustomerNotFoundException;

/*****
 *          @author          Bhavesh Rathi
 *          Description      It is a CustomerController - controller class. It provides 
 *                           RestMappings inorder to connect with the swagger. 
 *          Version          1.0     
 *          Created Date     11 - March - 2021
 ****/

@RestController
public class CustomerController {
	@Autowired
    private CustomerService customerservice;
	
	@Autowired
	private CustomerRepository customerRepository;
    
    // for inserting the customers
    @PostMapping("/customer")
    public Customer insertCustomer (@RequestBody @Valid Customer customer) { 
        return customerservice.insertCustomer(customer);
        }
    
    // for updating the customers 
    @PutMapping("/customer")
    public Customer updateCustomer  (@RequestBody Customer customer) {

        return customerservice.updateCustomer(customer);
        }
 
    @DeleteMapping("/customer/{customerid}")
    public Customer deleteCustomerById (@PathVariable("customerid") Integer customerId) throws CustomerNotFoundException {
    Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
	if(optionalCustomer.isEmpty())
		throw new CustomerNotFoundException("Customer not found with id:"+customerId);
	Customer customer = optionalCustomer.get();
	customerRepository.delete(optionalCustomer.get());
	return optionalCustomer.get();
    }

    // to get list of all customers 
    @GetMapping("/customers")
    public List<Customer>viewCustomers(){
    	return customerservice.viewCustomers();
    }
    }


