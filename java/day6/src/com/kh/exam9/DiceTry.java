package com.kh.exam9;

public class DiceTry {
    private int[] faceValue;
    private int tryTimes;
    private int sum;

    //
    public DiceTry() {
        this.tryTimes = 1;
    }

    //
    public void roll() {
        this.tryTimes = 1;
        faceValue =new int[1];
        this.roll(1);
    }

    public void roll(int times) {
        this.sum = 0;
        faceValue = new int[times];
        for (int i = 0; i < times; i++) {
            this.faceValue[i] = (int) Math.floor(Math.random() * 6 + 1);
            this.sum += this.faceValue[i];
        }
    }

    public int getResult() {
        return this.faceValue[0];
    }

    public int getResult(int index) {
        return this.faceValue[index];
    }
//
//    public void setFaceValue(int num) {
//        if (num >= 1 && num <= 6) {
//            this.faceValue = num;
//        }
//    }
}
