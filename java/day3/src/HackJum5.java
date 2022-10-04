import java.util.Scanner;

public class HackJum5 {
    public static void main(String[] args) {

        int korean = 0, english = 0, math = 0; //국영수 점수 초기화
        int sum = 0;
        double average = 0.0; //총점 및 평균 초기화
        boolean stop = false;

        System.out.println("<< 국, 영, 수 총점과 평균을 보여주는 프로그램(종료[Q,q]) >>");

        Scanner scanner = new Scanner(System.in);

        while (!stop) {

            korean = inputValue("국어");
            if (korean == -1) {
                continue;
            }
            english = inputValue("영어");
            if (english == -1) {
                continue;
            }
            math = inputValue("수학");
            if (math == -1) {
                continue;
            }

            sum = total(korean, english, math);
            average = calAverage(sum, 3);

            System.out.println("국어 : " + korean + " " + "영어 : " + english + "수학 : " + math);
            System.out.println("총점 : " + sum);
            System.out.println("평균 : " + average);
        }
    }

    public static int inputValue(String title) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(title + " 점수>> ");

        String input = scanner.nextLine();
        int score = 0;

        if (input.equals("Q") || input.equals("q")) {
            System.exit(0);
        } else if (Integer.parseInt(input) < 0 || 100 < Integer.parseInt(input)) {
            System.out.println("유효 범위(0~100점)를 벗어났습니다");
            score = -1;
        } else {
            score = Integer.parseInt(input);
        }
     //   int score = Integer.parseInt(input);
        return score;

    }

    public static int total(int k, int e, int m) {
        return k + e + m;
    }

    public static double calAverage(int total, int count) {
        return total / (double)count;
    }

}
