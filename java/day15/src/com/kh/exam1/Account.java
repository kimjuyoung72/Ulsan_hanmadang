package com.kh.exam1;

/**
 * 계좌 모델링
 */
public class Account {
    private String accountOwner;
    private int balance;

    public Account(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    /**
     * 입금
     * @param money 입금액
     */
    public void deposit(int money) throws DepositLimitException{
        if (money < 0) {
//            System.out.println("음수 허용 불가!");
//            return;
            throw new MinusException("음수 허용 불가!");
        }
        if (40_000 < money) {
//            System.out.println("입금한도 초과!");
//            return;
            throw new DepositLimitException("입금한도 초과!", new Throwable("40_000")); //chedked exception
        }
        balance += money;
    }

    /**
     * 출금
     * @param money 출금액
     */
    public void withdraw(int money) {
        if (money < 0) {
//            System.out.println("음수 허용 불가!");
            throw new MinusException("음수 허용 불가!");
        }
        if (40_000 < money) {
            System.out.println("출금한도 초과!");
            return;

        }
        balance -= money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountOwner='" + accountOwner + '\'' +
                ", balance=" + balance +
                '}';
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public int getBalance() {
        return balance;
    }
}
