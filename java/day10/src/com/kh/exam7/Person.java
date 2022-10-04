package com.kh.exam7;
/*
    abstract + class (미완성 개념) : abstract 접근지정자 .., 접근지정자 abstract
    1. 인스턴스를 만들 수 없다
    2. 타입(개념)으로는 사용 가능
    3.추상메소드가 없어도 abstract 키워드 사용가능
    abstract + method (미완성 메소드) :
    1. 메소드 선언부만 존재, 바디가 없다.
    2. abstract 메소드가 하나라도 존재하면 그 클래스는 abstract클래스여야 함.

*/

public abstract class Person {
    public Person() {
        super();
        System.out.println("사람 생성자 호출");
    }
    abstract public void smile();
    public void eat() {
        System.out.println("먹다.");
    }
}
