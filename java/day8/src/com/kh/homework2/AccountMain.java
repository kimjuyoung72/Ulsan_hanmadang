package com.kh.homework2;

import java.util.Scanner;

public class AccountMain {
    public static void main(String[] args) {
        final int END_INDEX = 7; //메뉴 끝 번호
        final int START_INDEX = 1;  //메뉴 시작 번호
        final int MAX_ACCOUNT = 5; //개설 가능 계좌 수
        final int LIMIT_ACCOUNT = 999; //한계 계좌 번호

        Account[] accounts = new Account[MAX_ACCOUNT];

        String[] menu = new String[]{"메뉴] ", "신규", "폐지", "입금", "출금", "계좌조회(개별)", "계좌조회(전체)", "종료"}; //메뉴 구성
        String input = ""; //문자열 입력용
        int num = 0; //정수값 입력용
        boolean stop = false; //루프 조건
        Scanner scanner = new Scanner(System.in);

        do {
            displayMenu(menu); //메뉴 표시
            System.out.print("메뉴를 선택하시오. >> ");
            num = Integer.parseInt(scanner.nextLine());

            while (num < START_INDEX || END_INDEX < num) { //메뉴 선택 입력 체크
                System.out.print("잘못된 입력입니다." + START_INDEX + " ~ " + END_INDEX + " 사이 번호를 선택하시오. >> ");
                num = Integer.parseInt(scanner.nextLine());
            }

            switch (num) {
                //=================================================
                case 1: //신규
                    if (openable(accounts)) { //계설 가능한 빈 곳이 있나?
                        System.out.println("계좌 개설이 가능합니다.");
                        System.out.print("개설할 계좌의 예금주 이름을 입력하시오. >> ");
                        input = scanner.nextLine();
                        int s = isExist(accounts, input); //동일 이름이 존재하는가?
                        if (s < 0) { //동일 이름이 없다면
                            makeAccount(accounts, input); //계좌 개설
                            System.out.println(input + "님의 계좌를 개설했습니다.");
                            System.out.println(accounts[isExist(accounts,input)]);
                        } else { //동일 이름이 있다면
                            System.out.println("이미 존재하는 계좌입니다.");
                        }
                    } else { //빈곳이 없다면..
                        System.out.println("계좌를 개설할 수 없습니다.");
                    }
                    break;
                //=================================================
                case 2: //폐지
                    if (isEmpty(accounts)) { //다 비어 있다면
                        System.out.println("계좌가 없습니다.");
                    } else { //개설된 계좌가 있다면
//                        System.out.print("폐지할 계좌의 예금주 이름을 입력하시오. >> ");
                        System.out.print("폐지할 계좌의 번호를 입력하시오. >> ");
//                        input = scanner.nextLine();
                        num = Integer.parseInt(scanner.nextLine());
                        while (num < 0 || LIMIT_ACCOUNT < num) {
                            System.out.println("올바른 계좌번호가 아닙니다.");
                            System.out.print("폐지할 계좌의 번호를 입력하시오. >> ");
                            num = Integer.parseInt(scanner.nextLine());
                        }
                        int s = isExist(accounts, num); //입력 번호와 일치하는 계좌가 있나?
                        if (s < 0) { //없다면
                            System.out.println("일치하는 계좌가 없습니다.");
                        }  else {
                            if (accounts[s].getBalance() > 0) { //잔고가 남아있다면 폐지X
                                System.out.println("잔고가 있어 폐지할 수 없습니다.");
                                System.out.println(accounts[s]);
                            }else {
                                System.out.println(accounts[s].getAccountOwner() + "님의 계좌가 폐지되었습니다.");
                                accounts[s] = null; //계좌 폐지
                            }
                        }
                    }
                    break;
                //=================================================
                case 3: //입금
                    if (isEmpty(accounts)) {
                        System.out.println("계좌가 없습니다.");
                    } else {
//                        System.out.print("입금 계좌의 예금주 이름을 입력하시오. >> ");
                        System.out.print("입금 계좌의 번호를 입력하시오. >> ");
//                        input = scanner.nextLine();
                        num = Integer.parseInt(scanner.nextLine());
                        while (num < 0 || LIMIT_ACCOUNT < num) {
                            System.out.println("올바른 계좌번호가 아닙니다.");
                            System.out.print("입금할 계좌의 번호를 입력하시오. >> ");
                            num = Integer.parseInt(scanner.nextLine());
                        }
//                        int s = isExist(accounts, input);
                        int s = isExist(accounts, num);
                        if (s < 0) {
                            System.out.println("일치하는 계좌가 없습니다.");
                        } else {
                            System.out.print("입금할 금액을 입력하시오. >> ");
                            num = Integer.parseInt(scanner.nextLine());
                            while (num < 1) {
                                System.out.println("정상 입금 금액(1이상)이 아닙니다.");
                                System.out.print("입금할 금액을 입력하시오. >> ");
                                num = Integer.parseInt(scanner.nextLine());
                            }
                            accounts[s].deposit(num);
                            System.out.println(accounts[s]);
                        }
                    }
                    break;
                    //===============================================
                case 4: //출금
                    if (isEmpty(accounts)) {
                        System.out.println("계좌가 없습니다.");
                    } else {
//                        System.out.print("출금 계좌의 예금주 이름을 입력하시오. >> ");
                        System.out.print("출금할 계좌의 번호를 입력하시오. >> ");
//                        input = scanner.nextLine();
                        num = Integer.parseInt(scanner.nextLine());
                        while (num < 0 || LIMIT_ACCOUNT < num) {
                            System.out.println("올바른 계좌번호가 아닙니다.");
                            System.out.print("출금할 계좌의 번호를 입력하시오. >> ");
                            num = Integer.parseInt(scanner.nextLine());
                        }
//                        int s = isExist(accounts, input);
                        int s = isExist(accounts, num);
                        if (s < 0) {
                            System.out.println("일치하는 계좌가 없습니다.");
                        } else {
                            System.out.print("출금할 금액을 입력하시오. >> ");
                            num = Integer.parseInt(scanner.nextLine());
                            while (num < 1) {
                                System.out.println("정상 출금 금액(1이상)이 아닙니다.");
                                System.out.print("출금할 금액을 입력하시오. >> ");
                                num = Integer.parseInt(scanner.nextLine());
                            }
                            accounts[s].withdraw(num);
                            System.out.println(accounts[s]);
                        }
                    }
                    break;
                //=================================================
                case 5: //조회 (개별)
                    if (isEmpty(accounts)) {
                        System.out.println("계좌가 없습니다.");
                    } else {
//                        System.out.print("조회할 계좌의 예금주 이름을 입력하시오. >> ");
                        System.out.print("조회할 계좌의 번호를 입력하시오. >> ");
//                        input = scanner.nextLine();
                        num = Integer.parseInt(scanner.nextLine());
                        while (num < 0 || LIMIT_ACCOUNT < num) {
                            System.out.println("올바른 계좌번호가 아닙니다.");
                            System.out.print("조회할 계좌의 번호를 입력하시오. >> ");
                            num = Integer.parseInt(scanner.nextLine());
                        }
//                        int s = isExist(accounts, input);
                        int s = isExist(accounts, num);
                        if (s < 0) {
                            System.out.println("일치하는 계좌가 없습니다.");
                        } else {
                            System.out.println(accounts[s]);
                        }
                    }
                    break;
                //=================================================
                case 6: //조회(전체)
                    if (isEmpty(accounts)) {
                        System.out.println("계좌가 없습니다.");
                        System.out.println("개설 가능 계좌수: " + countEmpty(accounts));
                    } else {
                       for(int i = 0; i< accounts.length; i++){
                           if (accounts[i] != null) {
                               System.out.println(accounts[i]);
                           }
                       }
                        System.out.print("개설 계좌수: " + (MAX_ACCOUNT - countEmpty(accounts)));
                        System.out.println(", 개설 가능 계좌수: " + countEmpty(accounts));
                    }
                    break;
                //=================================================
                case 7: //종료
                    stop = true;
                    break;
                default: break;
            }
        } while (!stop);
    }

    public static boolean openable(Account[] accounts) { //개설할 빈곳이 있는지 체크
        boolean flag = false;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static int getEmptyNumber(Account[] accounts) {
        int index = 0;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                index = i - 1;
                break;
            }
        }
        return index;
    }
    public static boolean isEmpty(Account[] accounts) { //개설된 계좌가 없는지 체크
        boolean flag = true;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                continue;
            } else {
                flag = false;
            }
        }
        return flag;
    }
    public static int isExist(Account[] accounts, String name) { //입력 이름과 일치하는 계좌가 있는지 체크해서 인덱스 반환
        int index = -1;

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                continue;
            }
            if (accounts[i].getAccountOwner().equals(name)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static int isExist(Account[] accounts, int num) { //입력 번호와 일치하는 계좌가 있는지 체크해서 인덱스 반환
        int index = -1;
        int tmp = 0;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                continue;
            }
            tmp = Integer.parseInt(accounts[i].getAccountNumber());
            if (tmp == num) {
                index = i;
                break;
            }
        }
        return index;
    }
    public static int countEmpty(Account[] accounts) { //개설 가능 계좌수는?
        int count = 0;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                count++;
            }
        }
        return count;
    }
    public static void makeAccount(Account[] accounts, String name) { //개설
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = new Account(name); //이름으로 생성
                break;
            }
        }
    }
    public static void displayMenu(String[] menu) { //메뉴 표시
        String menuBar = menu[0];
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        for (int i = 1; i < menu.length; i++) {
            menuBar += i + "." + menu[i] + "  ";
        }
        System.out.println(menuBar);
        System.out.println("-----------------------------------------------------------------------------------------------------------");
    }
}
