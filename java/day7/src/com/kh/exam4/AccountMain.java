package com.kh.exam4;

import java.util.Scanner;

public class AccountMain {
    public static void main(String[] args) {

        final int MAX_ACCOUNT = 10;
        Scanner scanner = new Scanner(System.in);

        boolean stop = false;
        Account[] accounts = new Account[MAX_ACCOUNT]; //10계좌까지 가능
        int makedAccount = 0;

        while (!stop) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("메뉴 ] 1.계좌 개설 2.입금 3.출금 4.잔액 5.종료");
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

            } else if (selectNum > 1 && selectNum < 5) { //예/출금,잔액조회

            } else { //범위밖 입력
                System.out.println();
                System.out.println("   ***잘못 입력 하셨습니다!***");
            }
            System.out.println();
        }
    }
}
