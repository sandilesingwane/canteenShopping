package com.ecommerce.myFriend.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller

public class productConroller {
    @Autowired
    private productService prodService;

    @GetMapping("/product")
    public String getProduct(Model model)
    {
        model.addAttribute("productRequest", new Product());
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String saveProduct( @RequestParam("file") MultipartFile file, @RequestParam("name") String name, @RequestParam("price") String price, @RequestParam("description") String description)
    {
        prodService.saveProduct(file,name,price,description);
        return "redirect:/dashboard";
    }



}
