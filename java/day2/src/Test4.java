public class Test4 {
    public static void main(String[] args) {

        // + : 피연산자 중 하나라도 문자열인 경우 문자열 연결 연산자.
        System.out.println(1 + 2);  //산술연산자
        System.out.println("1" + 2);    //문자열 연결 연산자
        System.out.println(1 + "2");    //문자열 연결 연산자

        int x = 10; int y = 20;
        int sum = x + y;
        System.out.println("sum = " + sum);
    }
}
