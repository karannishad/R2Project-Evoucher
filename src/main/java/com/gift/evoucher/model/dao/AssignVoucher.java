package com.gift.evoucher.model.dao;

import java.io.Serializable;
import java.util.ArrayList;

public class AssignVoucher implements Serializable {
    private Long mobileNo;
    private ArrayList<String> voucherId;

    public AssignVoucher() {
    }

    public AssignVoucher(Long mobileNo, ArrayList<String> voucherId) {
        this.mobileNo = mobileNo;
        this.voucherId = voucherId;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public ArrayList<String> getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(ArrayList<String> voucherId) {
        this.voucherId = voucherId;
    }
}
