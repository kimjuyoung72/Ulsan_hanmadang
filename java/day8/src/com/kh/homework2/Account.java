package com.kh.homework2;

public class Account {
    private static int count;
    private int countTmp; //남는 계좌 번호 저장용.
    private final int NUMBER_SIZE = 3;
    private String accountNumber;
    private final int MAX_DEPOSIT = 40000;

    private final int MAX_BALANCE = 100000;
    private final int MIN_BALANCE = 0;
    private String accountOwner;
    private long balance;

    public Account() {
        super();
    }

    public Account(String accountOwner) { //이름을 받아 생성
        this.accountOwner = accountOwner;
        ++count;
        String tmp = count + "";
        int size = NUMBER_SIZE - tmp.length();
        for (int i = 0; i < size; i++) {
            tmp = "0" + tmp;
        }
        accountNumber = tmp;
    }

    public void deposit(int deposit) { //예금
        if (MAX_DEPOSIT < deposit) {
            System.out.println("1회 입금한도( " + MAX_DEPOSIT + ")를 초과하였습니다.");
        } else if ((this.balance + deposit) > MAX_BALANCE) {
            System.out.println("예금 한도를 초과하였습니다.");
        } else {
            this.balance += deposit;
        }
    }

    public void withdraw(int withdraw) {

        if (MIN_BALANCE <= (this.balance - withdraw)) {
            this.balance -= withdraw ;
        } else {
            System.out.println("잔고가 부족합니다.");
        }
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Account.count = count;
    }

    public int getNUMBER_SIZE() {
        return NUMBER_SIZE;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "계좌[ " +
                "계좌번호: " + accountNumber +
                ", 예금주 : " + accountOwner +
                ", 예금액 :" + balance + " ]";
    }
}
