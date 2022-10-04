package com.kh.exam3;

import java.util.HashSet;
import java.util.Set;

public class PersonMain {
    public static void main(String[] args) {

        Set<Person> set = new HashSet<>();


        Person p1 = new Person("홍길동",30);
        Person p2 = new Person("홍길동", 30); //p1과동등객체
        Person p3 = new Person("홍길순",20);
        Person p4 = new Person("홍길동",40);

        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);

        System.out.println(set); //객체는 hashCode() -> equals()를 통과하며 비교하므로
                                                    //hashCode(), equals()를 재정의해 동등 객체가 될 조건을
                                                    //정해야 한다. 그렇지 않으면 항상 다른 객체로 판단.

        //Object.toString : 패키지.클래스@해시코드
//        System.out.println(p1);
//        System.out.println(p1.hashCode()); //인스턴스마다 다르다.
//        System.out.println(p2.hashCode());
//        System.out.println(p3.hashCode());
//        System.out.println(p4.hashCode());
    }
}
