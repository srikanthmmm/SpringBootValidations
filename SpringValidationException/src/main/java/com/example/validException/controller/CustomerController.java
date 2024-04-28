package com.example.validException.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validException.dto.CustomerDTO;
import com.example.validException.entity.Customer;
import com.example.validException.exc.CustomerNotFoundException;
import com.example.validException.service.CustomerService;

import lombok.val;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/save")
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody  CustomerDTO customerDTO){
	return new	ResponseEntity<Customer>(customerService.saveCustomer(customerDTO),HttpStatus.CREATED);
	}

	@GetMapping("/getAlll")
	public ResponseEntity<List<Customer>> getAll(){
	return new ResponseEntity<List<Customer>>(customerService.getAllCustomer(),HttpStatus.CREATED);
	}
	
	@GetMapping("/getById/{customerId}")
	public ResponseEntity<Customer> getById(@PathVariable Integer customerId)throws CustomerNotFoundException {
		return new ResponseEntity<Customer>(customerService.getCustomer(customerId),HttpStatus.CREATED);
	}	
}
