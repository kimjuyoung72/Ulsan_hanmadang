/*
증감연산자 : 선위 증감 연산자(++변수,--번수), 후위 증감연산자(변수++,변수--)
-단독일 경우 차이 없음.
-증감연산자가 식에 참여할때는 주의
    1.선위 증감 : 피연산자를 1증가 시킨 후 식에 참여.
    2.후위 증감 : 피연산자를 식에 참여한 후 1증감 시킴.
*/

public class incrementOperator {
    public static void main(String[] args) {

        int x = 1;
        int y = x++; //후위
        System.out.println("x = " + x + " ,y = " + y);

        int k = 1;
        int l = ++k; //선위
        System.out.println("k = " + k + " ,l = " + l);

        int i = 1;
        i++;
        System.out.println("i = " + i);

        int j = 1;
        ++j;
        System.out.println("j = " + j);
    }
}
