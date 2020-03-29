package com.github.AlGrom13.login;

import com.github.AlGrom13.login.model.AuthUser;

public interface AuthUserDao {

    AuthUser getByLogin(String login);

    boolean saveAuthUser(AuthUser user);
}
