package com.example.validException.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.validException.entity.Customer;
@Repository
public interface CustomerRepositery extends JpaRepository<Customer, Integer>{

	Customer findByCustomerId(Integer customerId);

}
