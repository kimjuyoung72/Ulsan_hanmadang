package com.kh.exam3;

public class Main {
    public static void main(String[] args) {
        //Wrapper class
        //byte -> Byte, short -> Short, char -> Character, int -> Integer
        //long -> Long, float -> Float, double -> Double, boolean -> Boolean
        //숫자 문자열 => 숫자
        String num = "10!";

        try {
            System.out.println(Integer.parseInt(num));
            System.out.println(Long.parseLong(num));
            System.out.println(Double.parseDouble(num));
            System.out.println(Float.parseFloat(num));
            System.out.println(Byte.parseByte(num));
            System.out.println(Short.parseShort(num));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("-----------------------------------------------------");
        //숫자 => 문자열
        int num2 = 10;
        String str = "" + num2;
        System.out.println(String.valueOf(num2));
        System.out.println("-----------------------------------------------------");
        double num3 = 3.14;
        System.out.println(String.valueOf(num3));
    }
}
