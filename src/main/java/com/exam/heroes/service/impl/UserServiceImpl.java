package com.exam.heroes.service.impl;

import com.exam.heroes.model.service.UserServiceModel;
import com.exam.heroes.repository.UserRepository;
import com.exam.heroes.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean register(UserServiceModel userServiceModel) {
        return false;
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return null;
    }
}
