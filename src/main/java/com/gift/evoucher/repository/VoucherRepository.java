package com.gift.evoucher.repository;

import com.gift.evoucher.model.User;
import com.gift.evoucher.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher,String> {


   List<Voucher> findAllByUser(User user);
}
