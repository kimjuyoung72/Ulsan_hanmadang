package com.kh.homework7;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.Scanner;

public class AccountMain {
    public static void main(String[] args) {

        final int MENU_INDEX = 7; //메뉴 종류

        final int ACCOUNT_INDEX = 10;

        Account[] accounts = new Account[ACCOUNT_INDEX];
        for (int i = 0; i < ACCOUNT_INDEX; i++) {
            accounts[i] = new Account();
            accounts[i] = null;
        }
        String[] menu = new String[]{"메뉴]", "개설", "입금", "출금", "조회", "계좌 폐지", "계좌 현황", "종료"};
        int Index = 0;
        int money = 0;
        String input = "";
        Scanner scanner = new Scanner(System.in); //ready for in..sys..bla~bla~

        boolean stop = false; //Loop condition
        int selectNumber = 0;
        do {
            displayMenu(menu); //메뉴 표시
            System.out.print("메뉴를 선택하세요 >> "); //..어떤걸 원하셈?
            selectNumber = Integer.parseInt(scanner.nextLine());
            while (selectNumber <= 0 || selectNumber > MENU_INDEX) {
                System.out.println("1~" + MENU_INDEX + " 사이의 번호를 입력하세요.");
                System.out.print("메뉴를 선택하세요 >> "); //..어떤걸 원하셈?
                selectNumber = Integer.parseInt(scanner.nextLine());
            }

            switch (selectNumber) {
                    case 1: //개설!! //빈계좌가 있다면 입력을 받아 있는 이름인지 확인하고 없으면 만든다.
                        if (isEmpty(accounts)) {
                            System.out.print("개설할 예금주 이름을 입력하시오. >> ");
                            input = scanner.nextLine();
                            if (isExist(accounts, input)) {
                                System.out.println("이미 존재하는 계좌입니다.");

                            } else {
                                makeAccount(accounts,input);
                            }
                        }else{
                            System.out.println("계좌 풀~");
                        }

                        break;
                    case 2: //입금
                        break;
                    case 3: //출금
                        System.out.println("3");

                        break;
                    case 4: //조회
                        System.out.println("4");
                        break;
                    case 5: //계좌 폐지
                        System.out.println("5");
                        break;
                    case 6: //계좌 현황
                        System.out.println("6");
                        break;
                    case 7: //종료
                        stop = true; //그만해~
                        break;
                    default:
                        break;

            }
    } while(!stop);
}

    public static boolean isEmpty(Account[] arr) {
        boolean flag = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static boolean isExist(Account[] arr, String  name) {
        boolean flag = false;
        String str = null;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                continue;
            }
            str = arr[i].getAccountOwner();
            if (str.equals(name)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void makeAccount(Account[] accounts, String name) {

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i].setAccountOwner(name);
            }
        }
    }
    public static void displayMenu(String[] arr) {
        String menuBar = "";
        menuBar += arr[0];
        System.out.println("------------------------------------------------------");
        for (int i = 1; i < arr.length; i++) {
            menuBar += i + "." + arr[i] + " ";
        }
        System.out.println(menuBar);
        System.out.println("------------------------------------------------------");
        System.out.println();
}
}
