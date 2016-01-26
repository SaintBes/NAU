package com.ukrinmash.ukraine.service;

import com.ukrinmash.ukraine.domain.User;

/**
 * Created by admssa on 21.11.2015.
 */
public interface UserService {
    public User registerNewUserAccount(String email, String password);
    public void updateUser(User user);

}
