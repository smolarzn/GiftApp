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

import java.util.Optional;

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

    @Override
    public UserTo findByUserName(String name) {
        UserEntity userByName = userRepository.findUserByUserName(name);
        if (userByName == null) {
            return null;
        }
        return UserMapper.map2To(userByName);
    }

    @Override
    public UserTo update(UserTo user) {
        Long userId = user.getId();
        Optional<UserEntity> byId = userRepository.findById(userId);
        if (byId.isEmpty()) {
            return null;
        }
        UserEntity userEntity = byId.get();
        UserEntity userEntityToUpdate = UserMapper.map2Entity(user, userEntity);
        userEntityToUpdate.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity updated = userRepository.save(userEntityToUpdate);
        return UserMapper.map2To(updated);
    }

    @Override
    public void delete(Long id) {
        Optional<UserEntity> byId = userRepository.findById(id);
        if (byId.isEmpty()) {
            return;
        }
        userRepository.delete(byId.get());
    }

    @Override
    public UserTo findById(Long id) {
        Optional<UserEntity> byId = userRepository.findById(id);
        if (byId.isEmpty()) {
            return null;
        }
        return UserMapper.map2To(byId.get());
    }
}
