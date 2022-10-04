package com.kh.exam5;

public class Main {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        // int result = changeInt(x, y);
        changeInt(x, y);
        System.out.println("x = " + x); //10
        System.out.println("y = " + y); //20

        System.out.println("================");
        int[] k = new int[2];
        changeArray(k);
        System.out.println("k[0] = " + k[0]); //30
        System.out.println("k[1] = " + k[1]); //40
    }

    public static void changeInt(int x, int y) {
//        x = x + 10;
//        return x + y;
        x = 30;
        y = 40;
    }

    public static int[] changeInt2(int x, int y) {
////
//        x = 30;
//        y = 40;
        int[] r = new int[]{x, y};
        return r;
    }

    public static void changeArray(int[] k) {
        k[0] = 30;
        k[1] = 40;
    }
}
