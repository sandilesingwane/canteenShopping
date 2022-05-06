package com.ecommerce.myFriend.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface usersRepositoryU extends JpaRepository<User,Integer> {

    Optional<User> findByLoginAndPassword(String login, String password);
}
