public class SwitchExam {
    public static void main(String[] args) {

        int num = 3;

        //switch문에서 case문 실행 후 break문장을 만날 때깢 순차적으로 실행된다.
        switch (num % 2) {
            case 1:
                System.out.println("Odd");
                break;
            case 0:
                System.out.println("Even");
                break; //switch 문에서 break문을 만나면 switch문을 빠져나온다
        }
    }
}
