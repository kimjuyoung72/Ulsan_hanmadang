public class ArrayTest2 {
    public static void main(String[] args) {
        //디폴트값을 원하는 값으로 초기화해서 배열 생성하기
//        int[] subject = new int[]{70, 80, 90};
        int[] subject;
        subject = new int[]{70, 80, 90}; //선언, 생성 분리 가능
        System.out.println(subject[0]);
        System.out.println(subject[1]);
        System.out.println(subject[2]);

        int[] subject2 = {70, 80, 90}; //선언, 생성 분리 불가
        System.out.println(subject2[0]);
        System.out.println(subject2[1]);
        System.out.println(subject2[2]);

    }
}
