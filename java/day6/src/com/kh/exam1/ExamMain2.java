package com.kh.exam1;

import java.util.Scanner;

public class ExamMain2 {
    public static void main(String[] args) throws Exception{
        Calculator c1 = new Calculator("빨강");
        Calculator c2 = new Calculator("깜장", "모닝글로리");
        //      c1.plus(10,20);
        //      System.out.println(c1.result);
        c1.powerOn();

        try {
            System.out.println(c1.getResult());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("값1 : ");
        //String input1 = scanner.nextLine();
        double x = Double.parseDouble(scanner.nextLine());

        System.out.print("값2: ");
        //String input2 = scanner.nextLine();
        double y = Double.parseDouble(scanner.nextLine());

        c1.plus(x, y);

        if (c1.isPower()) {
            System.out.println(c1.getResult());
        }
    }
}
