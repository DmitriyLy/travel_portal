package com.netcracker.services.impl;

import com.netcracker.entities.User;
import com.netcracker.repositories.impl.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepositoryImpl userRepository;

    @Transactional
    public User getUserById(long id){
        return userRepository.getById(id);
    }

}
