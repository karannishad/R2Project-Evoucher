package com.gift.evoucher.controller;

import com.gift.evoucher.model.User;
import com.gift.evoucher.model.Voucher;
import com.gift.evoucher.model.dao.LoginDao;
import com.gift.evoucher.service.VoucherService;
import com.gift.evoucher.util.VoucherGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VoucherController {

    @Autowired
    private VoucherService voucherService;

    @GetMapping("/getVouchers")
    public ResponseEntity<?> getAllVouchers(){
        List<String> vouchers = voucherService.getAllVoucher();
        System.out.println(vouchers);
        return new ResponseEntity<>(vouchers,HttpStatus.OK);
    }

    @PostMapping("/consumerVouchers")
    public ResponseEntity<?> getVoucherByConsumerId(@RequestBody User user){
        List<String> vouchers = voucherService.getVouchersById(user);

        return new ResponseEntity<>(vouchers, HttpStatus.OK);
    }
}
