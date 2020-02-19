package com.gift.evoucher.service;

import com.gift.evoucher.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findById(Long id);
}
