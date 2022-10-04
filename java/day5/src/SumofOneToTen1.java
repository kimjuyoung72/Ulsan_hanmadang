public class SumofOneToTen1 {
    public static void main(String[] args) {

        for_routine();
        while_routine();
        do_while_routine();
    }

    public static void for_routine() {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println("for문의 1~10합 = " + sum);
    }

    public static void while_routine() {
        int sum = 0, i = 1;
        while (i <= 10){
            sum += i;
            i++;
        }
        System.out.println("while문의 1~10합 = " + sum);
    }

    public static void do_while_routine() {
        int sum = 0, i = 1;
        do {
            sum += i;
            i++;
        } while (i <= 10);
        System.out.println("do-while문의 1~10합 = " + sum);
    }
}
