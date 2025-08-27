package com.fudai.user_management.POJO.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 * A class used to transfer data between layers
 * (like controller → service → front-end).
 */
public class UserDto {
    private Integer id;

    @NotBlank(message="Username cannot be blank")
    private String username;
    @NotBlank(message="Password cannot be blank")
    @Length(min = 2)
    private String password;
    @Email(message="Invalid Email format")
    private String email;

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
