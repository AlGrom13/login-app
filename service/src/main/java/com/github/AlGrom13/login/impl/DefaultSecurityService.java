package com.github.AlGrom13.login.impl;

import com.github.AlGrom13.login.AuthUserDao;
import com.github.AlGrom13.login.SecurityService;
import com.github.AlGrom13.login.model.AuthUser;

public class DefaultSecurityService implements SecurityService {
    private AuthUserDao authUserDao = DefaultAuthUserDao.getInstance();

    private static volatile SecurityService instance;

    public static SecurityService getInstance() {
        SecurityService localInstance = instance;
        if (localInstance == null) {
            synchronized (SecurityService.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DefaultSecurityService();
                }
            }
        }
        return localInstance;
    }

    @Override
    public AuthUser login(String login, String password) {
        AuthUser authUser = authUserDao.getByLogin(login);
        boolean isNotRegisteredUser = (authUser == null);
        if (isNotRegisteredUser) {
            return null;
        }
        boolean isPasswordCorrect = authUser.getPassword().equals(password);
        if (isPasswordCorrect) {
            return authUser;
        }
        return null;
    }
}
