package com.example.alif.mynote.model;

/**
 * Created by Ardhiansyah on 30/12/2015.
 */
public class UserData {
    String username, email, password;

    public UserData() {
    }

    public UserData(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
            return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
