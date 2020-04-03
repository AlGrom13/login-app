package com.github.AlGrom13.login.impl;

import com.github.AlGrom13.login.AuthUserDao;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestDefaultAuthUserDao4 {
    private static AuthUserDao authUserDao;

    @BeforeAll
    static void beforeAll() {
        authUserDao = DefaultAuthUserDao.getInstance();
    }

    @Test
    @DisplayName("Default users test.")
    void getByLoginTest() {
        String userLogin1 = "admin";
        String userLogin2 = "user";
        String userLogin3 = "user123";

        assertAll(
                () -> assertNotEquals(null, authUserDao.getByLogin(userLogin1)),
                () -> assertNotEquals(null, authUserDao.getByLogin(userLogin2)),
                () -> assertNull(authUserDao.getByLogin(userLogin3))
        );
    }
}