package com.kh.exam3;

import com.kh.exam2.AirConditioner;
import com.kh.exam2.Television;

public class Main {
    public static void main(String[] args) {

        HomeAppliances homeAppliances = new Radio();
        homeAppliances.on();
        homeAppliances.off();

        Radio radio = (Radio) homeAppliances;
        radio.matchChannel();

        //익명 클래스(인터페이스 구현 or 클래스 상속할때)
        //목적 : 1회성 인스턴스를 만들고 버림.
        //형태 : 생성자 + {};
        //방법1 : 인터페이스 메소드 구현을 통한 익명클래스
        HomeAppliances h1 = new HomeAppliances(){
            public void on() {
                System.out.println("켜다");
            }
            public void off() {
                System.out.println("끄다");
            }
        };
        h1.on();
        h1.off();

        //방법2 : 클래스 메소드 1회성 재정의
        Radio r1 = new Radio() {
            @Override
            public void matchChannel() {
                listener();
                System.out.println("음성으로 주파수 조정");
            }

            //음성인식
            void listener() {
                System.out.println("음성인식");
            }
        };

        r1.matchChannel();
    }
}
