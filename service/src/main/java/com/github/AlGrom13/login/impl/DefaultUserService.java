package com.github.AlGrom13.login.impl;

import com.github.AlGrom13.login.AuthUserDao;
import com.github.AlGrom13.login.UserService;
import com.github.AlGrom13.login.model.AuthUser;

import java.util.List;

public class DefaultUserService implements UserService {
    private AuthUserDao authUserDao = DefaultAuthUserDao.getInstance();

    private static volatile UserService instance;

    public static UserService getInstance() {
        UserService localInstance = instance;
        if (localInstance == null) {
            synchronized (UserService.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DefaultUserService();
                }
            }
        }
        return localInstance;
    }

    @Override
    public List<AuthUser> getUsers() {
        return authUserDao.getAllUsers();
    }
}
