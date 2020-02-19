package com.gift.evoucher.controller;

import com.gift.evoucher.model.Voucher;
import com.gift.evoucher.service.VoucherService;
import com.gift.evoucher.util.VoucherGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VoucherController {

    @Autowired
    private VoucherService voucherService;

    @GetMapping("/")
    public ResponseEntity<?> getVoucher(){
        List<Voucher> vouchers =new VoucherGenerator().generateVoucher();
        voucherService.saveAll(vouchers);
        return new ResponseEntity<>(vouchers, HttpStatus.OK);
    }
}
