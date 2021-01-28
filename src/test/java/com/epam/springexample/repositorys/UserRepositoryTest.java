package com.epam.springexample.repositorys;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.epam.springexample.model.UserAccountImpl;
import com.epam.springexample.model.UserImpl;
import com.epam.springexample.repositories.UserRepository;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    UserRepository userRepository;

    @Test
    void testFindByName() {
        UserAccountImpl userAccount = new UserAccountImpl(10d);
        UserImpl user = new UserImpl("Yevhenii Trokhniuk", "yevhenii_trokhniuk@epam.com", userAccount);
        entityManager.persist(user);
        String name = "Trokhniuk";
        List<UserImpl> users = userRepository.findByNameContaining(name);
        Assertions.assertThat(users).extracting(UserImpl::getName).containsOnly(user.getName());
        assertEquals(userAccount, user.getUserAccount());
    }

    @Test
    void testUserAccount() {
        UserAccountImpl userAccount = new UserAccountImpl(10d);
        UserImpl user = new UserImpl("Yevhenii Trokhniuk", "yevhenii_trokhniuk@epam.com", userAccount);
        entityManager.persist(user);
        UserImpl actualUser = userRepository.findById(user.getId()).orElseGet(UserImpl::new);
        assertEquals(user.getUserAccount(), actualUser.getUserAccount());
    }

}
