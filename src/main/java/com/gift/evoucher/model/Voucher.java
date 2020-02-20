package com.gift.evoucher.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Voucher {
    @Id
    private String voucherId;
    private int faceValue;
    private Date startDate;
    private Date lastDate;

    private Boolean isRedeemed;


    @ManyToOne(fetch = FetchType.EAGER,cascade= CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public Voucher() {
    }

    public Voucher(String voucherId, int faceValue, Date startDate, Date lastDate, Boolean isRedeemed) {
        this.voucherId = voucherId;
        this.faceValue = faceValue;
        this.startDate = startDate;
        this.lastDate = lastDate;
        this.isRedeemed = isRedeemed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(String voucherId) {
        this.voucherId = voucherId;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public Boolean getRedeemed() {
        return isRedeemed;
    }

    public void setRedeemed(Boolean redeemed) {
        isRedeemed = redeemed;
    }
}
