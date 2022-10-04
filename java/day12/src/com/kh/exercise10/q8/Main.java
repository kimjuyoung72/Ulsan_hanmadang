package com.kh.exercise10.q8;

public class Main {
    public static void main(String[] args) {

        A aa = new A();
        aa.m1();

        A ab = new B();

        System.out.println(ab.m);
        System.out.println(ab.n);
        System.out.println(B.n);
//        System.out.println(aa.m3);

        ab.m1();
        ab.m2();
        A.m2();
        B ba = (B)ab;
        ba.m3();

        B bb = new B();
        System.out.println(bb.m);
        System.out.println(bb.n);
        bb.m1();
        B.m2();
        bb.m3();

    }


}
