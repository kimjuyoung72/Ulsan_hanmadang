package com.kh.exam4;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.eat();
        p1.smile();
//        p1.study(); // X
        System.out.println("----------------");

        Student s1 = new Student();
        s1.smile();
        s1.eat();
        s1.study();

        Teacher t1 = new Teacher();
        t1.eat();
        t1.smile();
        t1.teach();

        //하위개념을 상위개념에 대입
        //하위개념의 실체를 상위 개념으로 다루겠다.
        Person p2 = s1; // <- is a. student is a person.
                                    // 자동 형변환

        //상위 개념을 하위개념에 대입(x)
//        Student s2 = p2;
        Student s2 = (Student) p2; //실체가 학생 타입인 s1을 대입했으므로
                                                    // p2 실체는 학생.
        s2.study();                         //실체가 강제형변환할려는 타입이어야한다.

        Person p3 = p1;                 //p3의 실체가 사람이므로 학생행동시 오류
        Student s3 = (Student) p3; //문법상 문제없지만 실행 예외(ClassCast..) 발생.
        s3.study();                         //컴파일 시점에서는 정상처리.
                                                    //실체가 강제형변환하려는 타입이어야한다!
    }
}
