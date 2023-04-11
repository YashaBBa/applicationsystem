package com.bsuir.applicationsystem.reops;

import com.bsuir.applicationsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserJpaRepo extends JpaRepository<User, Integer> {
    List<User> findAllByLogin(String name);

    User findByLogin(String login);

}
