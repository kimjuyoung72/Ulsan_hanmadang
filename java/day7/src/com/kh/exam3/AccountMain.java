package com.kh.exam3;

import java.util.Scanner;

public class AccountMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean stop = false;
        Account account = new Account();
//        Account account = new Account("홍길동");
        while (!stop) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("메뉴 ] 1.계좌 계설 2.입금 3.출금 4.잔액 5.종료");
            System.out.println("---------------------------------------------------------------");
            System.out.print("번호(1~5)를 입력하세요. >> ");

            int selectNum;
            String input = scanner.nextLine();
            selectNum = Integer.parseInt(input);

            if (selectNum == 5) { //종료
                System.out.println("***이용해 주셔서 감사합니다.***");
                stop = true;
                //   continue;
            } else if (selectNum == 1) { //계좌개설
                System.out.println();
                System.out.print("계좌를 개설합니다. 이름을 입력하세요 > ");
                input = scanner.nextLine();
                account.setAccountOwner(input);
                System.out.println();
                System.out.println("***" + account.getAccountOwner() + "님의 계좌를 개설하였습니다.***");
            } else if (selectNum > 1 && selectNum < 5) { //예/출금,잔액조회
                if (account.getAccountOwner() != null) {
                    switch (selectNum) {
                        case 2:
                            System.out.println();
                            System.out.print("입금액을 입력하세요 > ");
                            input = scanner.nextLine();
                            if (account.deposit(Integer.parseInt(input))) {
                                System.out.println();
                                System.out.println("***입금 한도(100000)를 넘었습니다.***");
                            } else {
                                System.out.println();
                                System.out.println(account);
                            }
                            break;
                        case 3:
                            System.out.println();
                            System.out.print("출금액을 입력하세요 > ");
                            input = scanner.nextLine();
                            switch (account.withdraw(Integer.parseInt(input))) {
                                case 1:
                                    System.out.println();
                                    System.out.println("***잔액 한도(-1000000)를 초과하였습니다.***");
                                    System.out.println();
                                    System.out.println(account);
                                    break;
                                case 0:
                                    System.out.println();
                                    System.out.println(account);
                                    break;
                                case -1:
                                    System.out.println("   ***금액을 잘못 입력 하셨습니다!***");
                                    break;
                            }
                            break;
                        case 4:
                            System.out.println();
                            System.out.println(account);
                            break;
                        default:
                            break;
                    }
                } else {
                    System.out.println();
                    System.out.println("***계좌가 없습니다. 개설하라구! 제발요~***");
                    continue;
                }
                // System.out.println();
            } else { //범위밖 입력
                System.out.println();
                System.out.println("   ***잘못 입력 하셨습니다!***");
            }
            System.out.println();
        }
    }
}
