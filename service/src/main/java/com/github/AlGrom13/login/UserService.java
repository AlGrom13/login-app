package com.github.AlGrom13.login;

import com.github.AlGrom13.login.model.AuthUser;

import java.util.List;

public interface UserService {

    List<AuthUser> getUsers();
}
