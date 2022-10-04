public class MaxValue {
    public static void main(String[] args) {

        int max, x = 5, y = 7, z = 4;
        max = x;
        char maxVariable = 'x';

        if (y > max) {
            max = y;
            maxVariable = 'y';
        }
        if (z > max) {
            max = z;
            maxVariable = 'z';
        }
        System.out.println("x = " + x + " y = " + y + " z = " + z);
        System.out.println("최대값은 " + maxVariable + " = " + max);
    }
}
