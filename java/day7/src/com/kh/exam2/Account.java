package com.kh.exam2;

import java.lang.*;

public class Account extends Object {
    private String accountOwner;  //예금주
    private long balance;  //잔액, 초기값 0L
//=============================================

//생성자,getter,setter,override 자동 생성 : alt + insert
    public Account(String accountOwner) {
        super();
        this.accountOwner = accountOwner;
    }

    //=============================================
    //입금
    public void deposit(int money) {
        this.balance += money;
    }

    //출금
    public void withdraw(int money) {
        this.balance -= money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "예금주 : '" + accountOwner + '\'' +
                ", 잔고 : " + balance +
                '}';
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
