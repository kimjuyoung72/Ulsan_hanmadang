package com.kh.exam3;

public class TelevisionDriver {
    public static void main(String[] args) {
// 실습 7.3: TelevisionDriver.java
// Television 객체를 만들어 이용한다


        // 첫 번째 Television 객체를 만든다
        Television televisionOne = new Television();

        // 첫 번째 Television 객체의 브랜드 이름을 ‘삼성’으로 한다
        televisionOne.setBrandName("삼성");

        // 첫 번째 Television 객체의 전원을 켠다
        // 여기에 코드를 삽입하세요
        televisionOne.setPowered(true);
        // 첫 번째 Television 객체의 채널 번호를 1번으로 한다
        // 여기에 코드를 삽입하세요
        televisionOne.setChannel(1);
        // 첫 번째 Television 객체의 볼륨을 6으로 한다
        // 여기에 코드를 삽입하세요
        televisionOne.setVolume(6);
        // 첫 번째 Television 객체의 모든 데이터 값들을 출력한다
        // 여기에 코드를 삽입하세요
        System.out.println(televisionOne.toString());
        // 첫 번째 Television 객체의 채널을 1만큼 감소시킨다
        // 여기에 코드를 삽입하세요
        televisionOne.decreamentChannel();
        // 첫 번째 Television 객체의 볼륨을 1만큼 증가시킨다
        // 여기에 코드를 삽입하세요
        televisionOne.increamentVolume();
        // 첫 번째 Television 객체의 모든 데이터 값들을 출력한다
        // 여기에 코드를 삽입하세요
        System.out.println(televisionOne.toString());
        // 두 번째 Television 객체를 만든다
        // 여기에 코드를 삽입하세요
        Television televisionTwo = new Television();
        // 두 번째 Television 객체의 브랜드 이름을 ‘엘지’로 한다
        // 여기에 코드를 삽입하세요
        televisionTwo.setBrandName("엘지");
        // 두 번째 Television 객체의 전원을 켠다
        // 여기에 코드를 삽입하세요
        televisionTwo.setPowered(true);
        // 두 번째 Television 객체의 채널 번호를 98번으로 한다
        // 여기에 코드를 삽입하세요
        televisionTwo.setChannel(98);
        // 두 번째 Television 객체의 볼륨을 12로 한다
        // 여기에 코드를 삽입하세요
        televisionTwo.setVolume(12);
        // 두 번째 Television 객체의 모든 데이터 값들을 출력한다
        // 여기에 코드를 삽입하세요
        System.out.println(televisionTwo.toString());
        // 두 번째 Television 객체의 채널을 1만큼 증가시킨다
        // 여기에 코드를 삽입하세요
        televisionTwo.increamentChannel();
        // 두 번째 Television 객체의 채널을 1만큼 증가시킨다
        // 여기에 코드를 삽입하세요
        televisionTwo.increamentChannel();
        // 두 번째 Television 객체의 볼륨을 1만큼 증가시킨다
        // 여기에 코드를 삽입하세요
        televisionTwo.increamentVolume();
        // 두 번째 Television 객체의 모든 데이터 값들을 출력한다
        // 여기에 코드를 삽입하세요
        System.out.println(televisionTwo.toString());
    }

}
