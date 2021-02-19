package com.exam.heroes.service;

import com.exam.heroes.model.service.UserServiceModel;

public interface UserService {

    boolean register(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

}
