package com.kh.exam9;

public class DiceTryMain {
    public static void main(String[] args) {

        DiceTry diceTry = new DiceTry();

        diceTry.roll();
        System.out.println("디폴트 1번 주사위 굴린값 : " + diceTry.getResult());
    }
}
