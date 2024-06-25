package com.dev.expense_app.service;

import com.dev.expense_app.entity.User;
import com.dev.expense_app.entity.UserModel;


public interface UserService {

    User createUser(UserModel user);

    User readUser(Long id);

    User updateUser(UserModel user, Long id);

    void deleteUser(Long id);
}
