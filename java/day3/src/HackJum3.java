import java.util.Scanner;

public class HackJum3 {
    public static void main(String[] args) {

        int korean = 0, english = 0, math = 0; //국영수 점수 초기화
        int sum = 0;
        double average = 0.0; //총점 및 평균 초기화
     //   boolean flag = true;

        Scanner scanner = new Scanner(System.in);
        System.out.println("[[ 국, 영, 수 총점과 평균을 보여주는 프로그램(종료[Q,q])");

     //   while (flag) {
        for( ; ; ){

            String input;

            System.out.print("국어 점수를 입력 하세요>> ");
            input = scanner.nextLine();
            if (input.equals("Q") || input.equals("q")) {
                return;
            }
            korean = Integer.parseInt(input);

            System.out.print("영어 점수를 입력 하세요>> ");
            input = scanner.nextLine();
            if (input.equals("Q") || input.equals("q")) {
                return;
            }
            english = Integer.parseInt(input);

            System.out.print("수학 점수를 입력 하세요>> ");
            input = scanner.nextLine();
            if (input.equals("Q") || input.equals("q")) {
                return;
            }
            math = Integer.parseInt(input);

            sum = total(korean, english, math);
            average = calAverage(sum, 3);

            System.out.println("국어 : " + korean + " " + "영어 : " + english + "수학 : " + math);
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

}
