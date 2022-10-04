import java.util.Arrays;

/*
 * Math.random() : 0 <= ? < 1 사이의 불특정 임의의 실수 발생
 * */
public class RandomExam4 {
    public static void main(String[] args) {

        int[] lotto = new int[]{0, 0, 0, 0, 0, 0,};

        int i = 0;
        do {

            int num = (int) (Math.floor(Math.random() * 45) + 1);

            if (isExist(lotto, num)) {
                continue;
            }
//            lotto[i] = num;
//            i++;
            lotto[i++] = num;
        }while (i < lotto.length);

        System.out.println(Arrays.toString(lotto));
    }

    //배열 내에 중복된 값이 있는지 체크하는 메소드
    public static boolean isExist(int[] arr, int num) {

        boolean result = false;

//        for (int i = 0; i < arr.length; i++) {

//            if (arr[i] == num) {
//                result = true;
//            }
//        }
        for (int k : arr) {
            if (k == num) {
                result = true;
            }
        }
        return result;
    }
}


