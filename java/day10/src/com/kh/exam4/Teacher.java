package com.kh.exam4;

public class Teacher extends Person {
    private int teacherId;

    public Teacher() {
        super();
    }
    public void teach() {
        System.out.println("가르치다.");
    }
}
