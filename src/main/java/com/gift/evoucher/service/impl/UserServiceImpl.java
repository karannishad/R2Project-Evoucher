package com.gift.evoucher.service.impl;

import com.gift.evoucher.model.User;
import com.gift.evoucher.repository.UserRepository;
import com.gift.evoucher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User saveUser(Long mobileNo) {
        return new User(mobileNo,"CONSUMER");
    }
}
