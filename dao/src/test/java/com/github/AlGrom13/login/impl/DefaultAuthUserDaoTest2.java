package com.github.AlGrom13.login.impl;

import com.github.AlGrom13.login.AuthUserDao;
import com.github.AlGrom13.login.model.AuthUser;
import com.github.AlGrom13.login.model.Role;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultAuthUserDaoTest2 {
    private static AuthUserDao authUserDao;

    @BeforeAll
    static void beforeAll() {
        authUserDao = DefaultAuthUserDao.getInstance();
    }

    @Test
    @DisplayName("Save new users test.")
    void saveAuthUserTest() {
        authUserDao.saveAuthUser(new AuthUser("user1", "qwe123", Role.USER));
        authUserDao.saveAuthUser(new AuthUser("user2", "1234"));

        assertAll(
                () -> assertNotEquals(null, authUserDao.getByLogin("user1")),
                () -> assertNotEquals(null, authUserDao.getByLogin("user2"))
        );
    }
}