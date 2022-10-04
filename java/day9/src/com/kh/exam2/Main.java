package com.kh.exam2;

public class Main {
    public static void main(String[] args) {
        int x = 10, y = 20;
        //     int result = sum(x, y); //정적 메소드인 main에서 인스턴스 메소드 호출 못함 -> 오류
        int result = sum2(x, y); //정적 메소드는 바로 호출 가능.

        Main main = new Main();
        main.sum(x, y); //인스턴스 생성 후 접근 가능.
    }

    private int sum(int x, int y) {

        int result = 0;

        result = x + y;
        return result;
    }

    private static int sum2(int x, int y) {

        int result = 0;

        result = x + y;
        return result;
    }

}
