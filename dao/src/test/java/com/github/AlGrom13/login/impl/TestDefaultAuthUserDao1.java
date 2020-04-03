package com.github.AlGrom13.login.impl;

import com.github.AlGrom13.login.AuthUserDao;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestDefaultAuthUserDao1 {
    private static AuthUserDao authUserDao;

    @BeforeAll
    static void beforeAll() {
        authUserDao = DefaultAuthUserDao.getInstance();
    }

    @Test
    @DisplayName("Only 2 default users")
    void getAllUsersTest() {
        assertEquals(2, authUserDao.getAllUsers().size());
    }
}