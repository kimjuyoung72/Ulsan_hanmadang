package com.kh.exam4;
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

     //    음성인식하다. (를 넣고 싶으나 넣으면 모든 구현들에 오류 발생...)
//     void listener();
     //default, static
     //1. java8 버전에 등장.
     //2. 목적 : 기존의 인터페이스를 구현하고 있던 구현체에 영향을 주지않고 기능 추가
     //3. default : 구현클래스에서 재정의 가능
     //4. static : 인터페이스.메소드명으로 사용
     default void listenVoice() {
         System.out.println("음성인식하다");

     }
     static void doInter(){ //static은 재정의 안됨.
         System.out.println("인터넷하다");
     }
}
