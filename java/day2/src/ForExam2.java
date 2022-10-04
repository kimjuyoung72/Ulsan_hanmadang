import java.util.Scanner;

public class ForExam2 {
    public static void main(String[] args) {
//        int gugudan;
//
//        // i++, ++i, i += 1, i = i + 1
//        for(gugudan = 2 ; gugudan < 10 ; gugudan++) {
//            for (int i = 1; i < 10; i++) {
//                System.out.println(gugudan + "*" + i + "=" + (gugudan * i));
//            }
//            System.out.println();
//        }
        System.out.println(">>구구단 출력하기 <<");

        Scanner scanner = new Scanner(System.in);
        System.out.print("출력할 구구단수 : ");
        int gugudan = Integer.parseInt(scanner.nextLine());


        for (int i = 1; i < 10; i++) {
            System.out.println(gugudan + "*" + i + "=" + (gugudan * i));
        }
    }
}
