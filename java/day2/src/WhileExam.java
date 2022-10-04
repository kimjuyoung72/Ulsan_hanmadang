public class WhileExam {
    public static void main(String[] args) {
//
//        for (초기식; 조건식; 증감식) {
//            실행문;
//        }
//
//        초기식;
//        while (조건식) {
//            실행문;
//            증감식;
//        }
//
//        초기식:
//        do {
//            실행문;
//            증감식
//        }while (조건식);
        int sum = 0;
        int i, n = 0;
        for ( i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println("1~10까지의 합 = " + sum);

        sum = 0;
        i = 1;
        while (i <= 10) {
            sum += i;
            i++;
            n++;
        }
        System.out.println("while 문 루프를 돈 횟수 = " + n);
        System.out.println("1~10까지의 합 = " + sum);

        sum = 0;
        i = 1;
        n = 0;
        do {
            sum += i;
            i++;
            n++;
        } while (i <= 10);
        System.out.println("do-while 문 루프를 돈 횟수 = " + n);
        System.out.println("1~10까지의 합 = " + sum);
    }
}
