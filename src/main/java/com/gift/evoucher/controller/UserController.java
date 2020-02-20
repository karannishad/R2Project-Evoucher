package com.gift.evoucher.controller;

import com.gift.evoucher.model.Voucher;
import com.gift.evoucher.model.dao.LoginDao;
import com.gift.evoucher.model.User;
import com.gift.evoucher.model.dao.AssignVoucher;
import com.gift.evoucher.service.UserService;
import com.gift.evoucher.service.VoucherService;
import com.gift.evoucher.util.VoucherGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    VoucherService voucherService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDao loginDao){
        Optional<User> user = userService.findById(loginDao.getId());

        if(user.isPresent())
        {
            return new ResponseEntity<>(user.get().getRole(), HttpStatus.OK);
        }
        else{
            User consumer =userService.saveUser(loginDao.getId());
            return new ResponseEntity<>(consumer.getRole(),HttpStatus.OK);
        }

    }

    @PutMapping("/assignVoucher")
    public ResponseEntity assignVoucher(@RequestBody AssignVoucher assignVoucher){
        System.out.println(assignVoucher.getMobileNo());
        System.out.println(assignVoucher.getVoucherId());
        Optional<User> user = userService.findById(assignVoucher.getMobileNo());
        if(user.isPresent())
        {
            List<Voucher> vouchers = new ArrayList<>();
            for(String voucherID:assignVoucher.getVoucherId()){
            Voucher voucher = voucherService.getVoucher(voucherID);
            voucher.setUser(user.get());
            vouchers.add(voucher);
            }
            voucherService.saveAll(vouchers);
            return new ResponseEntity(vouchers,HttpStatus.OK);
        }
        return new ResponseEntity("Exception Arised",HttpStatus.BAD_REQUEST);
    }

}
