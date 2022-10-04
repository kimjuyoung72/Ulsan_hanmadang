package com.kh.examAccount;

import java.util.Objects;


public class Account {
    private String accountName;
    private int balance;

    public Account(String accountName) {
        this.accountName = accountName;
    }

    //입금
    public void deposit(int money) throws Exception {
        if (money < 0) {
//            System.out.println("유효범위초과");
            throw new Exception("음수");
//            return;
        }
        if (40_000 < money) {
            throw new Exception("입금범위초과");
        }
        this.balance += money;
    }

    //출금
    public void withdraw(int money) throws WithdrawUnderException, WithdrawOverException{
        if (money < 0) {
            throw new WithdrawUnderException("음수");
        }
        if (40_000 < money) {

            throw new WithdrawOverException("출금범위초과");
//            return;
        }
        this.balance -= money;
    }
        @Override
    public String toString() {
        return "계좌 [ " +
                "예금주 : " + accountName +
                " ,예금 : " + balance + " ]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(accountName, account.accountName);
    }

    public String getAccountName() {
        return accountName;
    }

    public int getBalance() {
        return balance;
    }
}
