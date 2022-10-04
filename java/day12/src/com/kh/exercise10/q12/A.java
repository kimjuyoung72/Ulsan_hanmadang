package com.kh.exercise10.q12;
/*
 Object.equals() : 동일비교(==)로 정의
 동등비교를 하기 위해서는 Object.equals()를 재정의해서 사용.
* */
public class A {
    int data;

    A(int data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof A)) return false;
        A a = (A) o;
        return data == a.data;
    }
//    @Override
//    public boolean equals(Object obj) {
//        boolean flag = false;
//        if(this == obj) return true;
//        if (obj instanceof A) {
//            A a = (A) obj;
//            return this.data == ((A) obj).data;
//        }
//        return false;
//    }
}
