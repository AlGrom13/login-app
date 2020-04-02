package com.github.AlGrom13.login.impl;

import com.github.AlGrom13.login.AuthUserDao;
import com.github.AlGrom13.login.RegistrationService;
import com.github.AlGrom13.login.model.AuthUser;

public class DefaultRegistrationService implements RegistrationService {
    private AuthUserDao authUserDao = DefaultAuthUserDao.getInstance();

    private static volatile RegistrationService instance;

    public static RegistrationService getInstance() {
        RegistrationService localInstance = instance;
        if (localInstance == null) {
            synchronized (RegistrationService.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DefaultRegistrationService();
                }
            }
        }
        return localInstance;
    }

    @Override
    public boolean registerUser(AuthUser user) {
        if (authUserDao.getByLogin(user.getLogin()) != null) {
            return false;
        }
        authUserDao.saveAuthUser(user);
        return true;
    }
}
