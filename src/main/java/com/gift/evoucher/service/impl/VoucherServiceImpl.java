package com.gift.evoucher.service.impl;

import com.gift.evoucher.model.Voucher;
import com.gift.evoucher.repository.VoucherRepository;
import com.gift.evoucher.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VoucherServiceImpl implements VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;
    @Override
    public void save(Voucher voucher) {
        voucherRepository.save(voucher);
    }

    @Override
    public void saveAll(List<Voucher> vouchers) {
        voucherRepository.saveAll(vouchers);
    }
}
