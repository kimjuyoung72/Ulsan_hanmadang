import java.util.Scanner;

public class HackJum4 {
    public static void main(String[] args) {

        int korean = 0, english = 0, math = 0; //국영수 점수 초기화
        int sum = 0;
        double average = 0.0; //총점 및 평균 초기화

        System.out.println("[[ 국, 영, 수 총점과 평균을 보여주는 프로그램(종료[Q,q])");


        korean = inputValue("국어");
        english = inputValue("영어");
        math = inputValue("수학");

        sum = total(korean, english, math);
        average = calAverage(sum, 3);

        System.out.println("국어 : " + korean + " " + "영어 : " + english + "수학 : " + math);
        System.out.println("총점 : " + sum);
        System.out.println("평균 : " + average);

    }

    public static int inputValue(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(title + " 점수>> ");
        int score = Integer.parseInt(scanner.nextLine());
        return score;
    }

    public static int total(int k, int e, int m) {
        return k + e + m;
    }

    public static double calAverage(int total, int count) {
        return total / (double)count;
    }

}
