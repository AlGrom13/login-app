package com.github.AlGrom13.login.model;

public class AuthUser {
    private String login;
    private String password;
    private Role role;

    public AuthUser(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public AuthUser(String login, String password, Role role) {
        this(login, password);
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }
}
