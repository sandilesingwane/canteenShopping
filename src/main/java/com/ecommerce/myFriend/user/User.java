package com.ecommerce.myFriend.user;


import javax.persistence.*;
import java.util.Objects;



@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", Email='" + Email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNo=" + phoneNo +
                '}';
    }

    //@Column(nullable = false,name = "lastName",length = 50)
    private String lastName;
    //@Column(nullable = false,name = "firstName",length = 50)
    private String firstName;
    //@Column(nullable = false,unique = true,length = 50)
    private String Email;
   // @Column(nullable = false,length = 150)
    private String address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && lastName.equals(user.lastName) && firstName.equals(user.firstName) && Email.equals(user.Email) && address.equals(user.address) && phoneNo.equals(user.phoneNo) && password.equals(user.password) && login.equals(user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, Email, address, phoneNo, password, login);
    }

    // @Column(nullable = false,length = 10)
    private Integer phoneNo;
    //@Column(nullable = false,length = 50)
    private  String password;
    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Integer phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
