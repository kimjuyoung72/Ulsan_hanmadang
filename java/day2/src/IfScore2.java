import java.util.Scanner;

public class IfScore2 {
    public static void main(String[] args) {
//        90~100	A학점
//        80~89	B학점
//        70~79	C학점
//        60~69	D학점
//        60미만	F학점
        //int score = 87;


        Scanner scanner = new Scanner(System.in);
        System.out.println("<< 학점 구하기 >> 'Q'를 입력하면 종료합니다.");

//        boolean stop = false;
//
//        while (!stop) {
//        while (true) {
        for( ; ; ){
            System.out.print("점수를 입력하세요: ");
            String input = scanner.nextLine(); //콘솔에 입력된 라인을 문자열로 반환

            if (input.equals("Q")) {
                System.out.println("프로그램을 종료합니다");
                System.exit(0);
                //return;
            }

            int score = Integer.parseInt(input); //문자열을 정수로 변환

            if (score < 0 || score > 100) {
                System.out.println("점수(0~100범위 유효) 입력 오류");
                //return; //메소드 중지하고 빠져 나온다.
                continue;
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
}
