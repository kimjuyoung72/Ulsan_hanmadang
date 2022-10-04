
/*
변수와, 상수변수의 차이점과 용도
*/

public class Test1 {
    public static void main(String[] args) {

        int x; //선언
        x = 10; //초기화, 값 할당
        x = 20; //재할당
        System.out.println("x = " + x);

        final int Y; //상수 변수
        Y = 30; //초기화, 값 할당

//        Y = 40; //재할당:상수변수는 재할당 할 수 없다.
        System.out.println("Y = " + Y);
    }
}
