package com.dev.expense_app.security;

import com.dev.expense_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        com.dev.expense_app.entity.User existingUser = userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("User is not found for the email :"+ email));
        return new User(existingUser.getEmail(), existingUser.getPassword(),new ArrayList<>());
    }
}
