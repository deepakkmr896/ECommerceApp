package com.dev.ecommerce.domain;

import com.dev.ecommerce.enums.Gender;

public class CreateUserRequest {
    private String name;
    private String age;
    private Gender gender;
    private String phone;
    private String email;

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
