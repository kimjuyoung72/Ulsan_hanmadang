import java.util.Arrays;
import java.util.Scanner;

public class RandomExam101 {
    public static void main(String[] args) {

        boolean stop = false;

        Scanner scanner = new Scanner(System.in);
        System.out.println("**로또 번호 뽑기 프로그램** ");

        while (!stop) {

            int[] lotto = new int[6];
            int count = 0;

            System.out.print("종료[Q,q], 계속[나머지 입력]을 선택하세요.>> ");
            String input = scanner.nextLine();
            if (input.equals("Q") || input.equals("q") || input.equals("ㅂ") || input.equals("ㅃ")) {
                stop = true;
            }
            else {
                for (int i = 0; i < lotto.length; i++) {
                    int number = (int) (Math.floor(Math.random() * 45 + 1));
                    count++;

                    if (isExist(lotto,number)) {
                        i--;
                        continue;
                    }
                    lotto[i] = number;

                }
                System.out.println("for문 반복 횟수 : " + count);
                System.out.println("*777*100% 당첨 로또 번호!!!*777*");
                System.out.println(Arrays.toString(lotto));

            }
        }
    }

    public static boolean isExist(int[] arr, int num) {

        boolean exist = false;

        for (int k : arr) {
            if (k == num) {
                exist = true;
                break;
            }
        }
        return exist;
    }
}

