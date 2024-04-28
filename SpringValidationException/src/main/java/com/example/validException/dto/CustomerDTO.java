package com.example.validException.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.validException.entity.Customer;

import lombok.Data;

@Data
public class CustomerDTO {

	@NotNull(message = "Customer Name Should Not Be Null")
	@NotEmpty(message = "Customer Name Should Not Be Null")
	private String name;
	@Email(message = "Email must be a well formed email.address")
	private String email;
	@NotNull
	private String gender;
	@Min(18)
	@Max(60)
	private Integer age;
	@NotBlank(message = "Nationality should not be null")
	private String nationality;
	
	public static Customer prepareCustomer(CustomerDTO customerDto) {
		Customer custumer = new Customer();
		custumer.setName(customerDto.getName());
		custumer.setEmail(customerDto.getEmail());
		custumer.setAge(customerDto.getAge());
		custumer.setGender(customerDto.getGender());
		custumer.setNationality(customerDto.getNationality());
		return custumer;
	}
	
	
}
