package com.github.AlGrom13.login;

import com.github.AlGrom13.login.model.AuthUser;

public interface RegistrationAndSecurityService {

    AuthUser login(AuthUser user);

    boolean registerUser(AuthUser user);
}
