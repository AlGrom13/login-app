package com.github.AlGrom13.login;

import com.github.AlGrom13.login.model.AuthUser;

public interface SecurityService {

    AuthUser login(String login, String password);
}
