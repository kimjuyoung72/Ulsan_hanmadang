package com.kh.exam2;
 /*
 인터페이스의 특징
 1. 멤버 필드는 상수만! 표준화를 위해...(static final 생략가능)
 2. 멤버메소드는 추상 메소드. //메소드 선언부
 3. 모든 멤버는 public(명시하지 않아도 자동 적용)
 4. 인스턴스를 만둘 수 없다. 타입으로는 사용가능(구현체를 대입)
 5. 인터페이스 구현은 다중 구현이 가능
 6. 인터페이스간의 상속은 단일 상속
 cf) JDBC..
 * */
public interface HomeAppliances {
    public static final int voltage = 220;

    //전원 ON
    abstract public void on();
    //전원 OFF
    abstract public void off();
}
