package com.kh.exam6;

//final public class Person {
 /*
    final : 최종. 마지막의 ~
    final + 변수 : 초기화 후 재할당 불가.
    final + class : 최종 개념. 하위 개념이 올 수 없다. 상속 X
    final + method() : 최종형태. 하위개념에서 재정의가 불가능하다.
 * */
public class Person {
//    final public void smile() { //하위에서 재정의 불가

    public void smile() {
        System.out.println("웃다.");
    }
}
