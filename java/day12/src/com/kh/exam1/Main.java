package com.kh.exam1;

public class Main {
    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();
        Television television = new Television();
        Radio radio = new Radio();

        airConditioner.on();
        television.turnOn();
        radio.powerOn();
    }
}
