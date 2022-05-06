package com.ecommerce.myFriend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired private   userRepository repo;
    private final   usersRepositoryU userRepo;

    public UserService(usersRepositoryU userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> listAll()
    {
        return (List<User>) repo.findAll();
    }

    public User registerUser(String login,String Email, String password,String firstName,String lastName,String address,Integer phoneNo){

        if (login ==null || password == null)
        {
            return null;
        }else
        {
            User user = new User();
            user.setLogin(login);
            user.setEmail(Email);
            user.setAddress(password);
            user.setLastName(lastName);
            user.setFirstName(firstName);
            user.setPhoneNo(phoneNo);
            user.setPassword(address);
            return repo.save(user);
        }
    }
      public User authenticate(String login, String password)
      {
          return userRepo.findByLoginAndPassword(login,password).orElse(null);

      }



}
