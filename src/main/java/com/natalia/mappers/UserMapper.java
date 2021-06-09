package com.natalia.mappers;

import com.natalia.domain.UserEntity;
import com.natalia.types.UserTo;

import java.util.HashSet;
import java.util.Set;

public class UserMapper {

    private UserMapper() {
    }

    public static UserEntity map2Entity(UserTo userTo, UserEntity userEntity) {
        if (userTo == null) {
            return null;
        }
        if (userEntity == null) {
            userEntity = new UserEntity();
        }
        userEntity.setEmail(userTo.getEmail());
        userEntity.setPassword(userTo.getPassword());
        userEntity.setUserName(userTo.getName());
        return userEntity;
    }

    public static UserTo map2To(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        return UserTo.userBuilder()
                .withEmail(userEntity.getEmail())
                .withId(userEntity.getId())
                .withName(userEntity.getUserName())
                .withPassword(userEntity.getPassword())
                .withRoles(getUserRoleNames(userEntity)).build();
    }

    private static Set<String> getUserRoleNames(UserEntity entity) {
        Set<String> roles = new HashSet<>();
        entity.getRoles().forEach(roleEntity -> roles.add(roleEntity.getName()));
        return roles;
    }
}
