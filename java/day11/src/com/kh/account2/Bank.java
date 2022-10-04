package com.kh.account2;

public class Bank {
    private static final int OPEN_ACCOUNT_LIMIT = 5;
    private Account[] accounts = new Account[OPEN_ACCOUNT_LIMIT];
    private static final int NOT_FOUND = -1;

    //신규
    public void createAccount(String accountName) {

        int index = findNullIndex();
        if (index == NOT_FOUND) {
            System.out.println("계좌 개설 한도 초과.");
            return;
        }
//        index = findAccountByName();
//        if(index >= 0 ){
        if (dupCheckByName(accountName)) {
            System.out.println("같은 이름의 계좌 존재.");
            return;
        }
        accounts[index] = new Account(accountName);
        System.out.println(accountName + "님의 계좌가 개설되었습니다.");
        System.out.println(accounts[index]);
    }

    public int findAccountByName(String accountName) {
        int index = NOT_FOUND;

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                continue;
            }
            if (accounts[i].getAccountName().equals(accountName)) {
                index = i;
                break;
            }
        }
        return index;
    }
    //폐지
    public void closeAccount(String accountNumber) {
        int index = NOT_FOUND;
        index = findAccountByNumber(accountNumber);
        if (index == NOT_FOUND) {
            System.out.println("일치하는 계좌가 없습니다");
            return;
        }
        if (accounts[index].getBalance() > 0) {
            System.out.println("잔액이 있습니다.");
            System.out.println(accounts[index]);
        } else {
            System.out.println(accounts[index].getAccountName() + "님의 계좌가 폐지 되었습니다.");
            accounts[index] = null;
        }
    }

    //입금
    public void deposit(String accountNumber, int money) {

        int index = findAccountByNumber(accountNumber);
        if (index == NOT_FOUND) {
            System.out.println("일치하는 계좌가 없습니다");
            return;
        }
        accounts[index].deposit(money);
        System.out.println(accounts[index].toString());
    }

    //출금
    public void withdraw(String accountNumber, int money) {

        int index = findAccountByNumber(accountNumber);
        if (index == NOT_FOUND) {
            System.out.println("일치하는 계좌가 없습니다");
            return;
        }
        accounts[index].withdraw(money);
        System.out.println(accounts[index].toString());
    }

    //개별조회
    public void printAccount(String accountNumber) {
        int index = NOT_FOUND;
        System.out.print("계좌 번호 > ");
        index = findAccountByNumber(accountNumber);
        if (index == NOT_FOUND) {
            System.out.println("일치하는 계좌가 없습니다");
            return;
        }
        System.out.println(accounts[index].toString());
    }
    //전체조회
    public void printAllAccounts() {
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
    //종료
    //메뉴
    public void displayMenu() {
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("1.신규 2.폐지 3.입금 4.출금 5.계좌조회(개별) 6.계좌조회(전체) 7.종료");
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.print("선택 >> ");

    }

    private int findNullIndex() {
        int index = -1;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                index = i;
                break;
            }
        }
        return index;
    }

    private boolean dupCheckByName(String accountName) {
        boolean flag = false;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                continue;
            }
            if (accounts[i].getAccountName().equals(accountName)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    private int findAccountByNumber(String accountNumber) {
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