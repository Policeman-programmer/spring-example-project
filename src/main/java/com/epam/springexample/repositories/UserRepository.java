package com.epam.springexample.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.epam.springexample.model.UserImpl;

public interface UserRepository extends CrudRepository<UserImpl, Long> {
    List<UserImpl> findByNameContaining(String partOfName);
}
