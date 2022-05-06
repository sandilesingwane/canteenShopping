package com.ecommerce.myFriend.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
public class productService {
@Autowired
    private ProductRepository productRepo;

   public void saveProduct(MultipartFile file, String name, String description, String price)
   {
           Product prod = new Product();
           String fileName = StringUtils.cleanPath(file.getOriginalFilename());
           if (fileName.contains(".."))
           {
               System.out.println("Not a valid file");
           }
       try {
           prod.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
       prod.setDescription(description);
           prod.setName(name);
           prod.setPrice(Integer.parseInt(String.valueOf(price)));

           productRepo.save(prod);
   }

}
