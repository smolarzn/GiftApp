package com.natalia.domain;

import com.natalia.domain.validator.Password;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @Size(min = 1, max = 30)
    private String userName;

    @Password
    private String password;

    @Email(regexp = "[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}")
    private String email;

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
}
