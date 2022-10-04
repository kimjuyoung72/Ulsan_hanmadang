/*
변수의 생명주기(Life Cycle)
- 동일 블럭내에 동일 이름의 변수 선언은 불가.
- 변수가 선언된 블럭내에서 생명주기를 갖는다.
- 외부블럭에 선언된 변수는 내부블럭에서 접근 가능하다.
  반대로 내부블럭에 선언된 변수는 외부블럭에서 접근 불가능.
 */


public class Test2 {
    public static void main(String[] args) {

        int x = 10;
//        int x; //동일 블럭내에 동일한 이름을 갖는 변수 선언 불가
        {
            int y = 5;
            System.out.println("x = " + x);
            System.out.println("y = " + y);
        }

        method1(x);

//        for (int x = 1; i < 10; i++) {
//
//        }
    }
    public static void method1(int x) {
        int y = 20;
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }

}
