package com.natalia.types;

import com.natalia.domain.validator.Password;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserTo {

    private Long id;
    @NotEmpty
    private String name;
    @Password
    private String password;
    @Email(regexp = "[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public static UserBuilder userBuilder() {
        return new UserBuilder();
    }

    public static class UserBuilder {

        private Long id;
        private String name;
        private String password;
        private String email;

        public UserBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserTo build() {
            UserTo userTo = new UserTo();
            userTo.setEmail(email);
            userTo.setPassword(password);
            userTo.setName(name);
            userTo.setId(id);
            return userTo;
        }
    }
}
