package com.example.validException.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.validException.dto.CustomerDTO;
import com.example.validException.entity.Customer;
import com.example.validException.exc.CustomerNotFoundException;


public interface CustomerService {
	
	public Customer saveCustomer(CustomerDTO customerDTO);
	public List<Customer> getAllCustomer();
	public Customer getCustomer(Integer customerId) throws CustomerNotFoundException;
}
 