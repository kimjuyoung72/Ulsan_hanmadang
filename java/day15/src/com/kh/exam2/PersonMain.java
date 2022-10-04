package com.kh.exam2;

public class PersonMain {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();

        //Object.toString : 패키지.클래스@해시코드
        System.out.println(p1);
        System.out.println(p1.hashCode()); //인스턴스마다 다르다.
        System.out.println(p2.hashCode());
        System.out.println(p3.hashCode());
    }
}
