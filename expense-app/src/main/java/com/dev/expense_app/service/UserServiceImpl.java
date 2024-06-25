package com.dev.expense_app.service;

import com.dev.expense_app.entity.User;
import com.dev.expense_app.entity.UserModel;
import com.dev.expense_app.exceptions.ItemAlreadyExistException;
import com.dev.expense_app.exceptions.ResourceNotFoundException;
import com.dev.expense_app.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(UserModel userModel) {

        if(userRepository.existsByEmail(userModel.getEmail())){
            throw new ItemAlreadyExistException("User is already register with emil :"+userModel.getEmail());
        }
        User newUser = new User();
        BeanUtils.copyProperties(userModel, newUser);
        newUser.setPassword(bcryptEncoder.encode(newUser.getPassword()));
        return userRepository.save(newUser);
    }

    @Override
    public User readUser(Long id) {
        return userRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("User is not found for the id: "+id)
        );
    }

    @Override
    public User updateUser(UserModel user, Long id) {
        User existingUser = readUser(id);

        existingUser.setName(user.getName() != null ? user.getName() : existingUser.getName());
        existingUser.setEmail(user.getEmail() != null ? user.getEmail() : existingUser.getEmail());
        existingUser.setPassword(user.getPassword() != null ? bcryptEncoder.encode(user.getPassword()) : existingUser.getPassword());
        existingUser.setAge(user.getAge() != null ? user.getAge() : existingUser.getAge());

        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        User existingUser = readUser(id);
        userRepository.delete(existingUser);
    }
}
