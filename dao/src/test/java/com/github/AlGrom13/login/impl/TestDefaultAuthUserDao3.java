package com.github.AlGrom13.login.impl;

import com.github.AlGrom13.login.AuthUserDao;
import com.github.AlGrom13.login.model.AuthUser;
import com.github.AlGrom13.login.model.Role;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestDefaultAuthUserDao3 {
    private static AuthUserDao authUserDao;

    @BeforeAll
    static void beforeAll() {
        authUserDao = DefaultAuthUserDao.getInstance();
    }

    @Test
    @DisplayName("User can't be rewritable")
    void rewriteAuthUserTest() {
        String oldPassword = "user";
        authUserDao.saveAuthUser(new AuthUser("user", "qwe123", Role.USER));

        assertEquals(oldPassword, authUserDao.getByLogin("user").getPassword());
    }
}