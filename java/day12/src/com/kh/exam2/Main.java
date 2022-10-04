package com.kh.exam2;

public class Main {
    public static void main(String[] args) {
//        AirConditioner airConditioner = new AirConditioner();
//        Television television = new Television();
//        Radio radio = new Radio();
//
//        airConditioner.on();
//        television.on();
//        radio.on();

        HomeAppliances homeAppliances = new AirConditioner();
//        HomeAppliances homeAppliances1 = new AirConditioner();
//        HomeAppliances homeAppliances2 = new Television();
//        HomeAppliances homeAppliances3 = new Radio();
//
//        homeAppliances1.on();
//        homeAppliances2.on();
//        homeAppliances3.on();
        on(new AirConditioner());
        on(new Television());
        on(new Radio());

    }

    public static void on(HomeAppliances homeAppliances) {
        homeAppliances.on();
        homeAppliances.off();
    }

}
