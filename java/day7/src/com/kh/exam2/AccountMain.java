package com.kh.exam2;

public class AccountMain {
    public static void main(String[] args) {
        Account account = new Account("홍길동");
        System.out.println(account);

        account.deposit(100000); //입금
        System.out.println(account);
        account.deposit(100000); //입금
        System.out.println(account);
        account.withdraw(100000); //입금
        System.out.println(account);
        account.withdraw(100000); //입금
        System.out.println(account);
        account.withdraw(100000); //입금
        System.out.println(account);

//        long balance = account.getBalance();
//        System.out.println(balance);
//##    변수삭제하나로묶기 : ctrl + alt + n
        System.out.println(account.getBalance());

    }
}
