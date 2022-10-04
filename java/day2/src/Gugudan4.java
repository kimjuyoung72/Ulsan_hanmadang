import java.util.Scanner;

public class Gugudan4 {
    public static void main(String[] args) {

        boolean stop = false;

        Scanner scanner = new Scanner(System.in);
        System.out.println(">>구구단을 출력하는 프로그램<<");

        for( ; !stop ; ) {
            System.out.print("출력하고자 하는 구구단의 단수를 입력하세요. [Q,q]:종료 >> ");
            String input = scanner.nextLine(); //키보드로부터 엔터칠때까지 입력된 값을 문자열로 반환

            if (input.equals("Q") || input.equals("q")) { //문자열 비교
                System.out.println("프로그램을 종료합니다.");
//                break; //가장 가까운 반복문을 빠져나온다.
                stop = true;
                continue; //조건식으로 ~
            }
//            System.out.println(input);
            int dansu = Integer.parseInt(input); //문자열을 정수로 변환

            for (int i = 1; i < 10; i++) {
                System.out.println(dansu + " * " + i + " = " + (dansu * i));
            }
        }
    }
}
