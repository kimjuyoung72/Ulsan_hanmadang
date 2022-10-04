package com.kh.exam4;


import com.kh.exam2.Internet;

public class Television implements HomeAppliances, Internet {
    @Override
    public void on() {
        System.out.println("TV를 켜다");
    }

    @Override
    public void off() {
        System.out.println("TV를 끄다");
    }
    //Internet Interface 메소드의 다중구현
    @Override
    public String search(String keyWord) {

        return keyWord;
    }
}
