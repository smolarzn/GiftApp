package com.natalia.services;

import com.natalia.types.UserTo;

public interface UserService {

    UserTo save(UserTo user);

    UserTo findByUserName(String name);

    UserTo update(UserTo user);
}
