package com.natalia.services.impl;

import com.natalia.services.UserService;
import com.natalia.types.UserTo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@RunWith(SpringRunner.class)
//@Transactional
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

    @Test
    public void shouldFindUserByName() {
        //given
        String name = "Jan Kowalski";
        //when
        UserTo byName = userService.findByUserName(name);
        //then
        assertEquals(name, byName.getName());
    }

    @Test
    public void shouldNotFindUserByNameShouldReturnNull() {
        //given
        String name = "asdf";
        //when
        UserTo byName = userService.findByUserName(name);
        //then
        assertNull(byName);
    }

    @Test
    public void shouldUpdateUser() {
        //given
        String name = "Jan Kowalski";
        UserTo userToUpdate = userService.findByUserName(name);
        Long id = userToUpdate.getId();
        String newName = "Janek";
        String newPassword = "NewPassword";
        userToUpdate.setPassword(newPassword);
        userToUpdate.setName(newName);
        //when
        UserTo updatedUser = userService.update(userToUpdate);
        //then
        assertEquals(newName, updatedUser.getName());
        assertTrue(passwordEncoder.matches(newPassword, updatedUser.getPassword()));
        assertEquals(id, updatedUser.getId());
    }

    @Test
    public void shouldNotUpdateUserShouldReturnNull() {
        //given
        UserTo userToUpdate = UserTo.userBuilder()
                .withId(100L)
                .withEmail("email@gmail.com")
                .withName("name")
                .build();
        userToUpdate.setName("newName");
        //when
        UserTo updatedUser = userService.update(userToUpdate);
        //then
        assertNull(updatedUser);
    }


}