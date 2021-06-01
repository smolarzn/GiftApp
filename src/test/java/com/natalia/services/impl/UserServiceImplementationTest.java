package com.natalia.services.impl;

import com.natalia.services.UserService;
import com.natalia.types.UserTo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplementationTest {

    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void shouldSaveUser() {
        //given
        String name = "user name";
        String mail = "email@gmail.com";
        String password = "userPass.";
        UserTo userToSave = UserTo.userBuilder()
                .withName(name)
                .withEmail(mail)
                .withPassword(password)
                .build();
        //when
        UserTo userSaved = userService.save(userToSave);
        //then
        assertNotNull(userSaved);
        assertNotNull(userSaved.getId());
        assertEquals(name, userSaved.getName());
        assertEquals(mail, userSaved.getEmail());
        assertTrue(passwordEncoder.matches(password, userSaved.getPassword()));
    }



}