package com.kh.exam2;

//import java.util.Arrays;

public class DiceMain2 {
    public static void main(String[] args) {
        final int COUNT = 5;
        Dice[] dices = new Dice[COUNT];

        for (int i = 0; i < COUNT; i++) {
            dices[i] = new Dice();
        }
        int sum = 0;
        for (int i = 0; i < dices.length; i++) {
            dices[i].roll();
            System.out.println((i + 1) + "번째 주사위눈 : " + dices[i].getResult());
            sum += dices[i].getResult();
        }

        System.out.println(COUNT + "개 주사위 눈의 합 : " + sum);
    }
}
