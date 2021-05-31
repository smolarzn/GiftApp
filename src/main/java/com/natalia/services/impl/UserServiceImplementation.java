package com.natalia.services.impl;

import com.natalia.dao.UserRepository;
import com.natalia.domain.UserEntity;
import com.natalia.mappers.UserMapper;
import com.natalia.services.UserService;
import com.natalia.types.UserTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(UserServiceImplementation.class);

    @Autowired
    public UserServiceImplementation(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public UserTo save(UserTo user) {
        UserEntity userEntity = UserMapper.map2Entity(user, null);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        logger.info("{},{},{}", userEntity.getEmail(), userEntity.getPassword(), userEntity.getId());
        UserEntity saved = userRepository.save(userEntity);
        return UserMapper.map2To(saved);
    }
}
