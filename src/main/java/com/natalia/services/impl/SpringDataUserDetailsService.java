package com.natalia.services.impl;

import com.natalia.services.UserService;
import com.natalia.types.UserTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

public class SpringDataUserDetailsService implements UserDetailsService {

    private UserService userService;

    @Autowired
    public void setUserRepository(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserTo userTo = userService.findByUserName(username);
        if (userTo == null) {
            throw new UsernameNotFoundException(username);
        }
        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        userTo.getRoles().forEach(r -> grantedAuthoritySet.add(new SimpleGrantedAuthority(r)));
        return new User(userTo.getName(), userTo.getPassword(), grantedAuthoritySet);
    }
}
