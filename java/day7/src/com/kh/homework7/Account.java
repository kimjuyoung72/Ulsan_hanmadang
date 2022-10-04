package com.kh.homework7;

public class Account {
    final int MAX_DEPOSIT = 100000;
    final int MIN_BALANCE = -1000000;
    private String accountOwner;
    private long balance;

    public Account() {
        super();
    }

    public Account(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public void deposit(int deposit) { //예금
        if (deposit > 1 && deposit <= MAX_DEPOSIT) {
            this.balance += deposit;
        } else {

        }
    }

    public void withdraw(int withdraw) { //출금
        if (withdraw > 1 && MIN_BALANCE <= (this.balance - withdraw)) {
            this.balance -= withdraw;
        } else {

        }


    }



    public String getAccountOwner() {
        return this.accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public long getBalance() {
        return this.balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "계좌[ " +
                "예금주 : " + accountOwner + '\'' +
                ", 예금액 : " + balance +
                " ]";
    }
}
