package com.kh.exam2;

public class AirConditioner implements HomeAppliances{
    //전원 ON
    @Override
    public void off() {
        System.out.println("에어컨 켜다");
    }

    //전원 OFF
    @Override
    public void on() {
        System.out.println("에어컨 끄다");
    }
}
