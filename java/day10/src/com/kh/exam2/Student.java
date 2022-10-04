package com.kh.exam2;

public class Student extends Person{
    {
        System.out.println("4");
    }
    static {
        System.out.println("7");
    }
    public Student() {
        super(); //항상 최상단에 있어야한다.
        System.out.println("1");
//        super(); // X
//        System.out.println("2");
    }
}
