package com.kh.exam9;

public class Car extends Vehicle {
    // 승용차의 배기량에 대한 객체 변수를 선언한다
    private int volume;

    // 승용차의 모델명, 가격과 배기량을 주어진 값으로 초기화하면서
    // 객체를 생성한다

    public Car(String model, int price, int volume) {
        super(model, price);
        this.volume = volume;
    }

    // 승용차의 배기량을 반환한다
    public int getVolume() {
        return volume;
    }

    // 승용차의 세금을 계산한다
    @Override
    double calculateTex() {
        double tex = 0.;
        if (this.volume >= 3000) {
            tex = this.price * 0.05;
        } else if (this.volume >= 1500) {
            tex = this.price * 0.03;
        } else {
            tex = this.price * 0.01;
        }
        return tex;
    }

    // 승용차의 모델명, 가격과 배기량을 반환한다
    @Override
    public String toString() {
        return super.toString() + ", 배기량 : " + volume;
    }

    // 승용차의 배기량을 주어진 값으로 변경한다
    public void setVolume(int volume) {
        this.volume = volume;
    }
}