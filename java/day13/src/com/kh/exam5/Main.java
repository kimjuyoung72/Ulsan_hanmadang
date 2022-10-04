package com.kh.exam5;

public class Main {
    public static void main(String[] args) {//throws ArrayIndexOutOfBoundsException{ 생략된..

        method1();

    }

    private static void method1() { //throws ArrayIndexOutOfBoundsException{ 생략된..
        try {
            method2();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void method2() { //throws ArrayIndexOutOfBoundsException{ 생략된..
        int[] arr = new int[3];
        arr[3] = 10;
    }

}
