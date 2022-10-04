public class Excercise4_67 {
    public static void main(String[] args) {

        for (int i = 0 ; i < 10 ; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println("i = " + i + " ,j = " + j);
                if (i == 3 && j == 2) {
                    i = 9;
                    break;
                }

            }

        }

        ESC:
        for (int i = 0 ; i < 10 ; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 3 && j == 2) {
                    System.out.println("탈출시 i = " + i + " ,j = " + j);
                    break ESC;
                }
            }
        }
    }
}
