import java.util.Scanner;

public class InputTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//        System.out.print("정수를 입력하시오 :");
//        int i = scanner.nextInt();
//
//        System.out.println(i);

//        System.out.print("문자열을 입력하시오 :");
        System.out.print("숫자를 입력하시오 : ");
        String str = scanner.nextLine();
        System.out.println(str);
        int i = Integer.parseInt(str);
        System.out.println(i);
    }
}
