package com.kh.exam5;

public class Main {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;
       // int double z = sum(x, y); //int -> double 자동형변환
     //   byte b = (byte) sum(x, y); //결과 오류 발생 가능
    }

    public static int sum(double x, double y) {
        return (int) (x + y); //double -> int 결과 오류 발생 가능
    }
}
