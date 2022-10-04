
public class HackJum2 {
    public static void main(String[] args) {

        int korean = 85, english = 65, math = 92; //국영수 점수 초기화
        int sum = 0;
        double average = 0.0; //총점 및 평균 초기화

        sum = total(korean, english, math);
        average = calAverage(sum);

        System.out.println("국어 : " + korean + " " + "영어 : " + english + "수학 : " + math);
        System.out.println("총점 : " + sum);
        System.out.println("평균 : " + average);

    }

    public static int total(int k, int e, int m) {
        return k + e + m;
    }

    public static double calAverage(int s) {
        return s / (3 * 1.0);
    }
}