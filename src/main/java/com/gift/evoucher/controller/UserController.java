package com.gift.evoucher.controller;

import com.gift.evoucher.model.Voucher;
import com.gift.evoucher.model.dao.LoginDao;
import com.gift.evoucher.model.User;
import com.gift.evoucher.model.dao.AssignVoucher;
import com.gift.evoucher.service.UserService;
import com.gift.evoucher.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        return new ResponseEntity<>("User not valid",HttpStatus.FORBIDDEN);
    }

    @PutMapping("/assignVoucher")
    public ResponseEntity assignVoucher(@RequestBody AssignVoucher assignVoucher){
        System.out.println(assignVoucher.getMobileNo());
        System.out.println(assignVoucher.getVoucherId());
        Optional<User> user = userService.findById(assignVoucher.getMobileNo());
        if(user.isPresent())
        {
            Voucher voucher = voucherService.getVoucher(assignVoucher.getVoucherId());
            voucher.setUser(user.get());
            voucherService.save(voucher);
            return new ResponseEntity(voucher,HttpStatus.OK);
        }
        return new ResponseEntity("Exception Arised",HttpStatus.BAD_REQUEST);
    }

}
