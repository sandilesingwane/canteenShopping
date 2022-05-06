package com.ecommerce.myFriend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;


@Controller
public class UserController {

    @Autowired private UserService service;
    private userRepository repo;

     @GetMapping("/register")
    public String getRegisterPage(Model model)
     {
         model.addAttribute("registerRequest", new User());
         return "register_page";
     }

    @GetMapping("/login")
    public String getLoginPage(Model model)
    {
        model.addAttribute("loginRequest",new User());
        return "login_page";
    }
    @PostMapping("/register")
    public  String register(@ModelAttribute User user)
    {
        System.out.println("register request:"+ user);
        User registerUser =service.registerUser(user.getLogin(),user.getEmail(), user.getAddress(), user.getLastName(), user.getFirstName(), user.getPassword(), user.getPhoneNo());

        return registerUser == null ?"error_page" : "redirect:/login";


    }

    @PostMapping("/login")
    public  String login(@ModelAttribute User user, Model model)
    {
        System.out.println("login request:"+ user);
        User authenticatedUser =service.authenticate(user.getLogin(), user.getPassword());

        if (authenticatedUser != null)
        {
            model.addAttribute("userLogin",authenticatedUser.getLogin());
            return "productList";
        }
        else
        {
            return "error_page";
        }
    }
}
