public class IfScore {
    public static void main(String[] args) {

        int score;
        score = 87;

        if (90 <= score && score <= 100) {
            System.out.println("A학점");
        } else if (80 <= score && score <= 89) {
            System.out.println("B학점");
        } else if (70 <= score && score <= 79) {
            System.out.println("C학점");
        } else if (60 <= score && score <= 69) {
            System.out.println("D학점");
        } else {
            System.out.println("F학점");
        }
    }
}
