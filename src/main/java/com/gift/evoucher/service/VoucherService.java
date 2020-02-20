package com.gift.evoucher.service;

import com.gift.evoucher.model.User;
import com.gift.evoucher.model.Voucher;

import java.util.List;

public interface VoucherService {
    void save(Voucher voucher);
    void saveAll(List<Voucher> vouchers);
    Voucher getVoucher(String voucherId);

    List<String> getVoucherIds();
    List<String> getAllVoucher();


    List<String> getVouchersById(User user);
}
