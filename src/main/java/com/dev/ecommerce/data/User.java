package com.dev.ecommerce.data;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "user")
@Table(name = "dev_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;
    private String name;
    private String age;
    private String gender;
    private String phone;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    public User() {

    }

    public String getUserId() {
        return userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
