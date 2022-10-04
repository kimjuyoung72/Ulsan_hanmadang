import java.util.Scanner;

public class HackJum3_1 {
    public static void main(String[] args) {

        int korean = 0, english = 0, math = 0; //국영수 점수 초기화
        int sum = 0;
        double average = 0.0; //총점 및 평균 초기화

        Scanner scanner = new Scanner(System.in);
        System.out.println("[[ 국, 영, 수 총점과 평균을 보여주는 프로그램(종료[Q,q])");

        for( ; ; ){

            String input;
            int checkIn = 0;

            System.out.print("국어 점수를 입력 하세요>> ");
            input = scanner.nextLine();
            checkIn = checkInput(input);
            switch (checkIn) {
                case 1: System.exit(0);
                case 2: System.out.println("유효 범위(0~100점)를 벗어났습니다");
                    continue;
                default: english = checkIn;
                    break;
            }

            System.out.print("영어 점수를 입력 하세요>> ");
            input = scanner.nextLine();
            checkIn = checkInput(input);
            switch (checkIn) {
                case 1: System.exit(0);
                case 2: System.out.println("유효 범위(0~100점)를 벗어났습니다");
                    continue;
                default: english = checkIn;
                    break;
            }

            System.out.print("수학 점수를 입력 하세요>> ");
            input = scanner.nextLine();
            checkIn = checkInput(input);
            switch (checkIn) {
                case 1: System.exit(0);
                case 2: System.out.println("유효 범위(0~100점)를 벗어났습니다");
                    continue;
                default: math = checkIn;
                    break;
            }


            sum = total(korean, english, math);
            average = calAverage(sum, 3);

            System.out.println("국어 : " + korean + " " + "영어 : " + english + " 수학 : " + math);
            System.out.println("총점 : " + sum);
            System.out.println("평균 : " + average);
        }
    }

    public static int total(int k, int e, int m) {
        return k + e + m;
    }

    public static double calAverage(int total, int count) {
        return total / (double)count;
    }

    public static int checkInput(String keyIn) {

        if (keyIn.equals("Q") || keyIn.equals("q")) {
            return 1;
        } else if (Integer.parseInt(keyIn) < 0 || 100 < Integer.parseInt(keyIn)) {
            return 2;
        } else {
            return Integer.parseInt(keyIn);
        }

    }
}
