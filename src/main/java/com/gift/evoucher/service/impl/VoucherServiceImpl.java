package com.gift.evoucher.service.impl;

import com.gift.evoucher.model.User;
import com.gift.evoucher.model.Voucher;
import com.gift.evoucher.repository.VoucherRepository;
import com.gift.evoucher.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public Voucher getVoucher(String voucherId) {
        return voucherRepository.findById(voucherId).get();
    }

    @Override
    public List<String> getVoucherIds() {
        System.out.println(voucherRepository.findAll());
        return voucherRepository.findAll().stream()
                .map(x -> x.getVoucherId())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllVoucher() {
        return voucherRepository.findAll().stream()
                .filter(voucher -> !voucher.getRedeemed() && voucher.getUser()==null)
                .map(voucher -> voucher.getVoucherId())
                .collect(Collectors.toList());
    }

    @Override
    public List<Voucher> getVouchersById(User user) {
        return voucherRepository.findAllByUser(user);
    }

}
