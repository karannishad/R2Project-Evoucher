package com.gift.evoucher.repository;

import com.gift.evoucher.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
