package com.epam.springexample.repositories;

import org.springframework.data.repository.CrudRepository;

import com.epam.springexample.model.UserAccountImpl;

public interface UserAccountRepository extends CrudRepository<UserAccountImpl, Long> {
}
