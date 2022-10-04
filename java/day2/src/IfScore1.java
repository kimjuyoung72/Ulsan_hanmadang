import java.util.Scanner;

public class IfScore1 {
    public static void main(String[] args) {
//        90~100	A학점
//        80~89	B학점
//        70~79	C학점
//        60~69	D학점
//        60미만	F학점
        //int score = 87;

        //boolean flag = true;
        int score = 100;

        Scanner scanner = new Scanner(System.in);

        while (true) {

            //System.out.println("점수를 입력하세요: "); //줄바꿈
            System.out.print("점수를 입력하세요: "); //줄바꿈 안함
            score = scanner.nextInt(); //키보드로부터 정수값을 읽어 온다.

            if (score < 0 || score > 100) {
                System.out.println("점수(0~100범위 유효) 입력 오류");
                //메소드 중지하고 빠져 나온다.
            } else {
          //      flag = false;
                break;
            }
        }

        if (score >= 90 && score <= 100) {
            System.out.println("A학점");
        } else if (score >= 80 && score <= 89) {
            System.out.println("B학점");
        } else if (score >= 70 && score <= 79) {
            System.out.println("C학점");
        } else if (score >= 60 && score <= 69) {
            System.out.println("D학점");
        } else {
            System.out.println("F학점");
        }
    }
}
