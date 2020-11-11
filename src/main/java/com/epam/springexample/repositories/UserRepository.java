package com.epam.springexample.repositories;

import org.springframework.data.repository.CrudRepository;

import com.epam.springexample.model.UserImpl;

public interface UserRepository extends CrudRepository<UserImpl, Long> {
}
