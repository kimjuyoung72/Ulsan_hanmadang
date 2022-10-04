package com.kh.exam2;

public class SmartTv extends Television implements SmartInternet{
    @Override
    public void on() {
        System.out.println("스마트 티비를 켜다");
    }

    @Override
    public void off() {
        System.out.println("스마트 티비를 끄다");
    }

    @Override
    public String search(String keyWord) {
        System.out.println("검색어를 찾다");
        return keyWord;
    }

    @Override
    public void listenVoice() {
        System.out.println("스마트 티비가 음성을 인식한다");
    }
}
