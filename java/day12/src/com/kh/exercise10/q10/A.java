package com.kh.exercise10.q10;
/*
* this();, super(); 는 같이 올 수 없다.
* */
public class A {
    A() {
//        super(); 가 생략
        System.out.println("A 1");
    }

    A(int a) {
//        super(); 가 생략된것이 아니라 올 수 없다.
        this();

        System.out.println("A 2 " + a );
    }
}
