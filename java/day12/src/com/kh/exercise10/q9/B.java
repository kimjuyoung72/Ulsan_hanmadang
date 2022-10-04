package com.kh.exercise10.q9;

public class B extends A {
    B() {
//        int a = 1 //인스턴스를 먼저 생성해야하므로 super();앞에 어떤 코드도
                        //올 수 없다.
        super();
    }
    B(int a) {
        super(a);
    }
}

