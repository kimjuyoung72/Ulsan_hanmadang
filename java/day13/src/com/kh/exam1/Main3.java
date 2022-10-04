package com.kh.exam1;

public class Main3 {
    public static void main(String[] args) {

        try {
            method1();
        } //catch (ArrayIndexOutOfBoundsException e) {System.out.println(e.getMessage());}
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void method1() throws ArrayIndexOutOfBoundsException {
//    private static void method1() throws Exception { //이 경우 받는 쪽에서의 형변환 고려하거나 같은 Exception catch.
//    private static void method1() throws Exception, ArrayIndexOutOfBoundsException { //여러개 가능
        int[] arr = new int[3];

       arr[3] = 10;

    }
}
