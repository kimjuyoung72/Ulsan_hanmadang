public class HackJum {
    public static void main(String[] args) {

/*
        int[] subject = new int[3];

        subject[0] = 82; //국어점수
        subject[1] = 73; //영어점수
        subject[2] = 65; //수학점수 .. case 1
*/

//        int[] subject = new int[]{80, 90, 100} // case 2
        int[] subject = {80, 90, 100, 70}; // case 3

        int sum = 0;
        double average = 0.0;

        for (int i = 0; i < subject.length; i++) {
            sum += subject[i];
        }

        System.out.println("총점 = " + sum);

        average = sum / (double) subject.length;

        System.out.println("평균 = " + average);
    }
}
