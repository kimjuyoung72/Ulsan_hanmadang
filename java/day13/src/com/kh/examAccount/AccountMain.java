package com.kh.examAccount;

public class AccountMain {
    public static void main(String[] args) {
        Account account = new Account("홍길동");
        System.out.println(account);

        //입금
        try {
            account.deposit(50_000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(account);
        //출금
        try {
            account.withdraw(-5_000);
        } catch (WithdrawUnderException e) {
            System.out.println(e.getMessage());
        }catch (WithdrawOverException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(account);
        try {
            account.withdraw(50_000);
        } catch (WithdrawUnderException e) {
            System.out.println(e.getMessage());
        }catch (WithdrawOverException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(account);
    }
}
