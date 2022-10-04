package com.kh.exam2;
/*
* static 초기화 블럭: static 멤버필드를 초기화하기 위해 사용됨.
*                               (인스턴스 멤버필드 사용불가)
* 인스턴스 초기화 블럭:인스턴스멤버를 초기화하기 위해 사용됨.
*                               (생성자보다 먼저 실행된다)
* */
public class Person {
    static String national = "대한민국";
    String name;
    {
        System.out.println("5");
        name = "홍길동";
    }
    static {
        System.out.println("6");
        national = "Korea";
    }
    public Person() {
        super();
        System.out.println("3");
    }
}
