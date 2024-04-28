package com.example.validException.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.validException.dto.CustomerDTO;
import com.example.validException.entity.Customer;
import com.example.validException.exc.CustomerNotFoundException;
import com.example.validException.repo.CustomerRepositery;

@Service
public class CustomerServiceIMPL implements CustomerService {

	@Autowired
	private CustomerRepositery customerRepo;
	
		
	@Override
	public Customer saveCustomer(CustomerDTO customerDTO) {
		return customerRepo.save(CustomerDTO.prepareCustomer(customerDTO));
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepo.findAll();
	}

	@Override
	public Customer getCustomer(Integer customerId) throws CustomerNotFoundException{
		
		Customer customer= customerRepo.findByCustomerId(customerId);
	if(customer!=null) 
		return customer;
	else
		throw new CustomerNotFoundException("Customer ID not Found");

	}

}
