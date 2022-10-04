public class SwitchExam2 {
    public static void main(String[] args) {
        int num = 7;

        //연산식 결과가 정수,문자열,열거타입
        switch (num % 4) {
            case 1:
                System.out.println("나머지가 1인 경우");
                break;
            case 2:
                System.out.println("나머지가 2인 경우");
                break;
            case 3:
                System.out.println("나머지가 3인 경우");
                break;
            default:
                System.out.println("나머지가 0인 경우");
        }
    }
}
