package com.kh.exam3;

public class PersonMain {
    public static void main(String[] args) {
        Person p1 = new Person("홍길동", 35);
        Person p2 = new Person("홍길동", 35);

        System.out.println(p1==p2); //동일(물리적) 비교
        System.out.println(p1.equals(p2)); //동등(내용적) 비교
    }
}
