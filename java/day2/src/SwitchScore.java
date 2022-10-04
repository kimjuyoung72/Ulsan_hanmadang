public class SwitchScore {
    public static void main(String[] args) {
        int score = 1200;

        //유효성 체크
        if (!(score >= 0 && score <= 100)) {
            System.out.println("점수 유효범위(0~100)을 벗어났습니다.");
            return;
        }

        int result = score / 10;

        switch (result) {
            case 10:
            case 9: //90~
                System.out.println("A학점");
                break;
            case 8: //80~89
                System.out.println("B학점");
                break;
            case 7: //70~79
                System.out.println("C학점");
                break;
            case 6: //60~69
                System.out.println("D학점");
                break;
            default: //~59
                System.out.println("F학점");
        }
        //System.out.println(score / 10);
    }
}
