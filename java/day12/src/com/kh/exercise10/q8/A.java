package com.kh.exercise10.q8;
/*
* 1.상속관계에서 멤버 필드는 상속되지 않는다.(재정의 할 수 없다.)
* 2. 상속관계에서 인스턴스 멤버 메소드는 상속될때 재정의 할 수 있다.
* 3. static 멤버는 클래스, 인터페이스에 고정되어 사용된다.
* */

public class A {
    int m = 2;
    static int n = 4;
    void m1() {
        System.out.println("A instace method");
    }
    static void m2() {
        System.out.println("A static method");
    }
    private void m3() {
        System.out.println("A private instance method");
    }
}
