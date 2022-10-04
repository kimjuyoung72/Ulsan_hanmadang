package com.kh.exam2;

public class Dice {

    private int faceValue;

    //
    public Dice() {
        this.faceValue = 1;
    }

    //
    public void roll() {
        this.faceValue = (int) Math.floor(Math.random() * 6 + 1);

    }

    public int getResult() {
        return this.faceValue;
    }
//
//    public void setFaceValue(int num) {
//        if (num >= 1 && num <= 6) {
//            this.faceValue = num;
//        }
//    }
}
