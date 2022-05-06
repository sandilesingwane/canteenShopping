package com.ecommerce.myFriend.user;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface userRepository extends CrudRepository<User,Integer> {
    public  Long countById(Integer id);

     User findById(String userId);

    @Override
    Optional<User> findById(Integer integer);
}
