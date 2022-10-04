package com.kh.account2;

import java.util.Scanner;

public class AccountMain {
    public static void main(String[] args) {
        Bank bank  = new Bank();

        Scanner scanner = new Scanner(System.in);
        String select = null;
        boolean stop = false;
        int money = 0;
        String accountName = null;
        String accountNumber = null;


        while (!stop) {
            bank.displayMenu();
            select = scanner.nextLine();

            switch (select) {
                case "1": //신규
                    System.out.print("이름 > ");
                    accountName = scanner.nextLine();
                    bank.createAccount(accountName);
                    break;
                case "2": //폐지
                    System.out.print("계좌 번호 > ");
                    accountNumber = scanner.nextLine();
                    bank.closeAccount(accountNumber);
                    break;
                case "3": //입금
                    System.out.print("계좌 번호 > ");
                    accountNumber = scanner.nextLine();
                    System.out.print("입금액 > ");
                    money = Integer.parseInt(scanner.nextLine());
                    bank.deposit(accountNumber,money);
                    break;
                case "4": //출금
                    System.out.print("계좌 번호 > ");
                    accountNumber = scanner.nextLine();
                    System.out.print("출금액 > ");
                    money = Integer.parseInt(scanner.nextLine());
                    bank.withdraw(accountNumber,money);
                    break;
                case "5": //조회(개별)
                    System.out.print("계좌 번호 > ");
                    accountNumber = scanner.nextLine();
                   bank.printAccount(accountNumber);
                    break;
                case "6": //조회(전체)
                    bank.printAllAccounts();
                    break;
                case "7": //종료
                    stop = true;
                    continue;
                default:
                    System.out.println("선택한 메뉴가 없습니다.");
            }
        }
    }
}
