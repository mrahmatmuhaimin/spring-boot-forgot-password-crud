package com.muhaimin.springbootresetpasswordapplication.service.implementation;

import com.muhaimin.springbootresetpasswordapplication.entity.User;
import com.muhaimin.springbootresetpasswordapplication.repository.RoleRepository;
import com.muhaimin.springbootresetpasswordapplication.repository.UserRepository;
import com.muhaimin.springbootresetpasswordapplication.service.framework.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder,
                           RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

}
