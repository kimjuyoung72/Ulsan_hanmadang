package com.kh.exercise12.q8;

public class B implements A{
    @Override
    public void abc() {
        A.super.abc(); //default 메소드 호출
        System.out.println("B 클래스의 abc()");
//        A.def(); //static 메소드 호출
    }
}
