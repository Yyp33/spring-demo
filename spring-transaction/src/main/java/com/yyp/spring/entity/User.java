package com.yyp.spring.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class User {
    private Integer id;
    private String realName;
    private String cardNo;
    private Integer balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", realName='" + realName + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", balance=" + balance +
                '}';
    }
}
