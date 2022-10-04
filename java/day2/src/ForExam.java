public class ForExam {
    public static void main(String[] args) {
        int sum = 0;

//        for (초기값; 조건식; 증감식) {
//            실행문;
//        }
//        for(int i = 1 ; i <= 100 ; i++) {
//            //sum = sum + 1; //sum += 1, sum++, ++sum
//            if(i % 2 == 0) {
//                sum += i; //sum = sum + i
//            }
//        }
//        for(int i = 0 ; i <= 100 ; i += 2) {
//            //sum = sum + 1; //sum += 1, sum++, ++sum
//
//                sum += i; //sum = sum + i
//
////        }
//        for (int i = 0; i < 100; i++) {
//            if (i % 2 == 1) {
//                sum += i;
//            }
//        }
        for (int i = 1; i < 100; i += 2) {
            sum += i;
        }
        System.out.println(sum);
    }
}
