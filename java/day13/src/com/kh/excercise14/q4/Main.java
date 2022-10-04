package com.kh.excercise14.q4;

public class Main {
    public static void main(String[] args) {
        try {
            int[] array = new int[]{1, 2, 3};
            System.out.println(array[3]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열...");
        } catch (Exception e) { //상위 개념이 밑으로...
            System.out.println("다른...");
        }
    }
}
