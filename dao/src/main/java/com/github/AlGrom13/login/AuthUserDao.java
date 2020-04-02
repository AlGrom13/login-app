package com.github.AlGrom13.login;

import com.github.AlGrom13.login.model.AuthUser;

import java.util.List;

public interface AuthUserDao {

    List<AuthUser> getAllUsers();

    AuthUser getByLogin(String login);

    void saveAuthUser(AuthUser user);
}
