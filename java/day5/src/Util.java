public class Util {
    public boolean isExist(int[] arr, int num) {

        boolean result = false;

        for (int k : arr) {
            if (k == num) {
                result = true;
                break;
            }
        }
        return result;
    }
    public static void printLine(char ch, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(ch);
        }
        System.out.println();
    }

}
