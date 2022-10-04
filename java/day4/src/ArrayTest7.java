import java.util.Arrays;

public class ArrayTest7 {
    public static void main(String[] args) {

        int[] x = new int[]{1, 2, 3, 4, 5};

        for (int i = 0; i < x.length; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
        System.out.println("++++++++++++++++++++++++++");
        //향상된 for문
        //for (요소를 대입할 변수 : 배열 or 컬렉션){}
        int i = 0;
        for (int k : x) {
            System.out.println("x["+i+"]="+k);
            i++;
        }
        System.out.println(Arrays.toString(x));
    }
}
