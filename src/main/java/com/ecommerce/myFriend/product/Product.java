package com.ecommerce.myFriend.product;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    private Integer id;
    private  String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && id.equals(product.id) && name.equals(product.name) && description.equals(product.description) && image.equals(product.image) && image.equals(product.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, description, image, image);
    }

    private int price;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    private String description;



    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Lob
    @Column(columnDefinition  ="MEDIUMBLOB")
    private String image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }




}
