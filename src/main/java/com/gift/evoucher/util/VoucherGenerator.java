package com.gift.evoucher.util;

import com.gift.evoucher.model.Voucher;

import java.util.*;

public class VoucherGenerator {

    private  String getAlphaNumericString(int n)
    {

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
    public List<Voucher> generateVoucher(){
        List<Voucher> vouchers = new ArrayList<>();
        Set<String> voucherSet = new HashSet<>();
        int i=0;
        while(i<100){
            String temp = getAlphaNumericString(15);
            if(!voucherSet.contains(temp)){
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DATE,30);
                vouchers.add(new Voucher(temp,250,new Date(),calendar.getTime(),false));
                i++;
            }
        }
        return vouchers;
    }
}
