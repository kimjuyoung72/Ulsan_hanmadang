package com.kh.exam2;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        System.out.println(s1.name);
        System.out.println(s1.national); //권장하지 않는다.
        System.out.println(Person.national); //static은 클래스로 접근 권장.
    }
}
