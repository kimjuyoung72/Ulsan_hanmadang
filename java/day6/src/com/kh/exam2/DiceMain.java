package com.kh.exam2;

import java.util.Scanner;

public class DiceMain {
    public static void main(String[] args) {

        int sum;
        Scanner scanner = new Scanner(System.in);

        Dice dice1 = new Dice();
        Dice dice2 = new Dice();

        boolean stop = false;

        do {
            System.out.print("주사위를 두번 굴립려면[Enter], 나갈려면 [Q,q]");
            String input = scanner.nextLine();

            if (input.equals("Q") || input.equals("q")) {
                stop = true;
                continue;
            }
            else {
                dice1.roll();
                dice2.roll();
                //    sum = dice1.faceValue + dice2.faceValue;
//    System.out.println("주사위 1: " + dice1.faceValue + ", 주사위 2: " + dice2.faceValue + ", 합 : " + sum);
                sum = dice1.getResult() + dice2.getResult();
                System.out.println("[주사위1]: " + dice1.getResult() + ", [주사위2] : " + dice2.getResult() + ", 합 : " + sum);

                if (sum > 10) {
                    System.out.println("당첨");
                } else {
                    System.out.println("꽝!");
                }
            }
        } while (!stop);
    }
}
