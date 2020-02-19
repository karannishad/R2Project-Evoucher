package com.gift.evoucher.model;

import java.io.Serializable;

public class LoginDao implements Serializable {
   private Long id;

   public LoginDao(){}
    public LoginDao(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
