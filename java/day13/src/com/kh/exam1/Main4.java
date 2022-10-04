package com.kh.exam1;

public class Main4 {
    public static void main(String[] args) {//throws Exception{

        try {
            method1();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void method1() throws Exception {
        method2();
    }

    private static void method2() throws Exception {
        int[] arr = new int[3];

        for (int i = 0; i < 4; i++) {
            if (i > 2) {
                throw new Exception("인덱스 범위 초과");
            }
            arr[i] += 1; //예외 발생시 실행안됨
        }
//        try {
//            arr[3]  = 10;
//        } catch (Exception e) {
//
//            throw new Exception("인덱스 범위 초과");
//        }
    }
}
