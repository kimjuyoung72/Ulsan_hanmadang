package com.kh.account;

import java.util.Scanner;

public class AccountMain {
    static final int NOT_FOUND = -1;
    public static void main(String[] args) {

        //메뉴
        displayMenu();

    }
    private static void displayMenu() {
        final int OPEN_ACCOUNT_LIMIT = 5;
        Account[] accounts = new Account[OPEN_ACCOUNT_LIMIT];
        boolean stop = false;

        outer:
        while (!stop) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("------------------------------------------------------------------------------------------------");
            System.out.println("1.신규 2.폐지 3.입금 4.출금 5.계좌조회(개별) 6.계좌조회(전체) 7.종료");
            System.out.println("------------------------------------------------------------------------------------------------");
            System.out.print("선택 >> ");

            String select = scanner.nextLine();
            int index = NOT_FOUND;
            int money = 0;
            String accountName = null;
            String accountNumber = null;

            switch (select) {
                case "1" : //신규
                    System.out.print("이름 > ");
                    accountName = scanner.nextLine();
                    index = findNullIndex(accounts);
                    if (index == NOT_FOUND) {
                        System.out.println("계좌 개설 한도 초과.");
                        continue;
                    }
                    accounts[index] = new Account(accountName);
                    System.out.println(accountName + "님의 계좌가 개설되었습니다.");
                    System.out.println(accounts[index]);
                    break;
                case "2" : //폐지
                    System.out.print("계좌 번호 > ");
                    accountNumber = scanner.nextLine();
                    index = findAccount(accounts, accountNumber);
                    if (index == NOT_FOUND) {
                        System.out.println("일치하는 계좌가 없습니다");
                        continue;
                    }
                    if (accounts[index].getBalance() > 0) {
                        System.out.println("잔액이 있습니다.");
                        System.out.println(accounts[index]);
                    }else {
                        accounts[index] = null;
                    }
                    break;
                case "3" : //입금

                    int limitCnt = 0;
                    while (true) {
                        System.out.print("계좌 번호 > ");
                        accountNumber = scanner.nextLine();
                        index = findAccount(accounts, accountNumber);
                        if (index == NOT_FOUND) {
                            System.out.println("일치하는 계좌가 없습니다");
                            if (3 == ++limitCnt) {
                                continue outer; //중춥반복문에서 2단계 이상으로 분기하고자 할때 라벨사용
                            }
                            continue;
                        }
                        break;
                    }
                    System.out.print("입금액 > ");
                    money = Integer.parseInt(scanner.nextLine());
                    accounts[index].deposit(money);
                    System.out.println(accounts[index]);
                    break;
                case "4" : //출금
                    System.out.print("계좌 번호 > ");
                    accountNumber = scanner.nextLine();
                    index = findAccount(accounts, accountNumber);
                    if (index == NOT_FOUND) {
                        System.out.println("일치하는 계좌가 없습니다");
                        continue;
                    }
                    System.out.print("출금액 > ");
                    money = Integer.parseInt(scanner.nextLine());
                    accounts[index].withdraw(money);
                    System.out.println(accounts[index]);
                    break;
                case "5" : //조회(개별)
                    System.out.print("계좌 번호 > ");
                    accountNumber = scanner.nextLine();
                    index = findAccount(accounts, accountNumber);
                    if (index == NOT_FOUND) {
                        System.out.println("일치하는 계좌가 없습니다");
                        continue;
                    }
                    System.out.println(accounts[index]);
                    break;
                case "6" : //조회(전체)
                    printAllAccount(accounts);
                    break;
                case "7" : //종료
                        stop = true;
                    continue;
                default:
                    System.out.println("선택한 메뉴가 없습니다.");
            }
        }
        System.out.println("종료!");
    }

    private static void printAllAccount(Account[] accounts) {
        int cnt = 0;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                continue;
            }
            cnt++;
            System.out.println(accounts[i]);
        }
        if (cnt == 0) {
            System.out.println("개설된 계좌가 없습니다.");
        } else {
            System.out.println("개설계좌수 : " + cnt + "개설가능 계좌수 : " + (accounts.length - cnt));
        }
    }

    private static int findNullIndex(Account[] accounts){
        int index = -1;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                index = i;
                break;
            }
        }
        return index;
    }

    private static int findAccount(Account[] accounts, String accountNumber) {
        int index = -1;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                continue;
            }
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
