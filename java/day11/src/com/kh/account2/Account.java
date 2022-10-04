package com.kh.account2;

public class Account {
    private static int count = 0;
    private final int ACCOUNT_NUM_SIZE = 3;
    //에금주 이름, 잔고, 계좌번호
    private String accountName;
    private String accountNumber;
    private int balance;
//
//    public Account() {
//        super();
//    }

    public Account(String accountName) {
        this.accountName = accountName;
        accountNumber = createAccountNumber(++count);
    }

    //입금
    public void deposit(int money) {
        if (money < 1 || 40_000 < money) {
            System.out.println("입금 범위 초과");
        }else {
            if (100_000 < (balance + money)) {
                System.out.println("예치 범위 초과");
            }else {
                balance += money;
            }
        }
    }

    //출금
    public void withdraw(int money) {
        if (money < 1 || 40_000 < money) {
            System.out.println("출금 범위 초과");
        }else {
            if ((balance - money) < 0 ) {
                System.out.println("잔액 부족");
            }else {
                balance -= money;
            }
        }
    }
    //조회
    @Override
    public String toString() {
        return "예금주명 : " + accountName +
                ", 계좌번호 :  " + accountNumber +
                ", 잔액 : " + balance;
    }
    //계좌생성
    private String createAccountNumber(int accountNum) {
        String str = "" + accountNum;
        int addZeros = ACCOUNT_NUM_SIZE - str.length();
        for (int i = 0; i < addZeros; i++) {
            str = "0" + str;
        }
        return str;
    }

    public int getBalance() {
        return balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
