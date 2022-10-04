public class ArrayTest3 {
    public static void main(String[] args) {

        int[] subject = new int[3]; //초기화는 0

        subject[0] = 80; //재할당
        subject[1] = 70; //재할당
        subject[2] = 50; //재할당

        System.out.println(subject[0]);
        System.out.println(subject[1]);
        System.out.println(subject[2]);

        System.out.println("배열의 인덱스는 " + subject.length);

        for (int i = 0; i < 3; i++) {
            System.out.println(subject[i]);
        }

        for (int i = 0; i < subject.length; i++) {
            System.out.println(subject[i]);
        }
    }
}
