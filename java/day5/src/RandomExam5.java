import java.util.Arrays;

/*
 * Math.random() : 0 <= ? < 1 사이의 불특정 임의의 실수 발생
 * */
public class RandomExam5 {
    public static void main(String[] args) {

        int[] lotto = new int[6];
        boolean stop = false;

        int count = 0;
        while (!stop) {

            int num = (int) (Math.floor(Math.random() * 45) + 1);
            //동일 번호 존재하면 번호 다시 생성
            if (isExist(lotto, num)) {
                continue;
            }
            //아니면 배열에 저장
            else {
              lotto[count++] =num;
            }
            //번호 6개가 다 차면 루프를 탈출.
            if (count == 6) {
                stop = true;
                //break;
            }
        }

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


