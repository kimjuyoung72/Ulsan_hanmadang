import java.util.Arrays;
import java.util.Scanner;

public class RandomExam100 {
    public static void main(String[] args) {

//        int[] lotto = new int[6];
        boolean stop = false;

        Scanner scanner = new Scanner(System.in);
        System.out.println("**로또 번호 프로그램** ");

        while (!stop) {
            int[] lotto = new int[]{0,0,0,0,0,0};
            int count = 0; //test var.
            System.out.print("게속[Enter], 종료[Q,q]를 선택하세요.>> ");
            String input = scanner.nextLine();
            if (input.equals("Q") || input.equals("q")) {
                stop = true;
            } else if (input.equals("")) {

                boolean flag = false;

                for (int i = 0; i < lotto.length; i++) {
                    int number = (int) (Math.floor(Math.random() * 45 + 1));
                    flag = isExist(lotto, number);
                    if (!flag) {    //중복된게 없다면..
                        lotto[i] = number;
                    } else {
                        i--;
                    }
                    count++;
                }
                System.out.println("루프 반복 횟수 : " + count);
                System.out.println("*777*100% 당첨 로또 번호!!!*777*");
                System.out.println(Arrays.toString(lotto));
            } else {
                System.out.println("잘못 입력했습니다.");
            }
        }
    }

    public static boolean isExist(int[] arr, int num) {

        boolean exist = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                exist = true;
                break;
            }
        }
        return exist;
    }
}

