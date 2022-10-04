package com.kh.exam3;
//메뉴 ] 1.계좌 계설 2.입금 3.출금 4.잔액 5.종료
//        요구사항)
//        1.계좌 개설시 이름을 입력 받도록 한다.
//        2.1회 입금한도는 10만원을 넘지 못한다.
//        3.마이너스 잔액 한도는 100만원이다.
//        4.계좌 개설 전에는 2~4번 메뉴를 사용할 수 없다.
public class Account {

    private final int MIN_BALANCE = -1000000; //잔액 한도
    private final int MAX_DEPOSIT = 100000; //입금 한도
    private String accountOwner;
    private long balance;

    public Account() {
        super();
    }
    public Account(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public Account(String accountOwner, long balance) {
        this.accountOwner = accountOwner;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "거래 결과 { " +
                "예금주 : '" + accountOwner + '\'' +
                ", 잔고 : " + balance +
                " }";
    }

    public boolean deposit(int deposit) {
        boolean flag = false;
        if (deposit > 0 && deposit <= MAX_DEPOSIT) {
            this.balance += deposit;
        } else {
            flag = true;
        }
        return flag;
    }

    public int withdraw(int withdraw) {
        int check = 0;
        if (withdraw < 1) {
            check = -1;
        }
        if ((this.balance - withdraw) >= MIN_BALANCE) {
            this.balance -= withdraw;
        } else {
            check = 1;
        }
        return check;
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
