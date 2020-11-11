package com.epam.springexample.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.epam.springexample.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);

	Customer findById(long id);
}
