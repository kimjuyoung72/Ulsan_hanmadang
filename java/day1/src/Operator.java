public class Operator {
    public static void main(String[] args) {
        int x = 10;

        //대입연산자 : =, 산술연산자=
        x = x + 1;  // x += 1

        System.out.println(x);

        x += 1;
        System.out.println(x);

        x -=1;
        System.out.println(x);

        x *= 2; // x = x * 2
        System.out.println(x);

        x /= 2; // x = x / 2
        System.out.println(x);

        x %= 2; // x = x % x
        System.out.println(x);

    }
}
