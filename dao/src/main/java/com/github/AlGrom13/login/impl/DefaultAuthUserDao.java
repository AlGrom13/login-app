package com.github.AlGrom13.login.impl;

import com.github.AlGrom13.login.AuthUserDao;
import com.github.AlGrom13.login.model.AuthUser;
import com.github.AlGrom13.login.model.Role;


import java.util.HashMap;
import java.util.Map;

public class DefaultAuthUserDao implements AuthUserDao {
    Map<String, AuthUser> userByLogin;

    public DefaultAuthUserDao() {
        this.userByLogin = new HashMap<>();
        this.userByLogin.putIfAbsent("admin",
                new AuthUser("admin", "admin", Role.ADMIN);
        this.userByLogin.putIfAbsent("user",
                new AuthUser("user", "user", Role.USER));
    }

    private static volatile AuthUserDao instance;

    public static AuthUserDao getInstance() {
        AuthUserDao localInstance = instance;
        if (localInstance == null) {
            synchronized (AuthUserDao.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DefaultAuthUserDao();
                }
            }
        }
        return localInstance;
    }

    @Override
    public AuthUser getByLogin(String login) {
        return null;
    }

    @Override
    public boolean saveAuthUser(AuthUser user) {
        return false;
    }
}
