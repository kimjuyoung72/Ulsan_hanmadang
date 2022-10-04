package com.kh.exercise10.q8;

public class B extends A{
    int m = 3;
    static int n = 8;

    public B() {
//        this.m = super.m;

    }

    void m1() {
        System.out.println("B instance method");
    }
    static void m2() {

        System.out.println("B static method");
    }
    void m3(){
        System.out.println("B instance method2");
    }
}
