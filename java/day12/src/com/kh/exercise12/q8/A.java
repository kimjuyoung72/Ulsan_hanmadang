package com.kh.exercise12.q8;

interface A {
    default void abc() {
        System.out.println("A 인터페이스의 abc()");
    }
    static void def() {
        System.out.println("A의 정적메소드");
    }
}
