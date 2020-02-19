package com.gift.evoucher.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class User {

    @Id
    private Long mobileNo;
    private String role;


    public User() {
    }

    public User(Long mobileNo, String role) {
        this.mobileNo = mobileNo;
        this.role = role;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
