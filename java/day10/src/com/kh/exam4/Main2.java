package com.kh.exam4;

public class Main2 {
    public static void main(String[] args) {
        int x = 10;
        double y = x; //자동형변환. 작은 타입을 큰 타입에 대입
//        x = y; //큰타입을 작은타입에 대입할 수 없다.
        x = (int) y; //큰나입을 작은 타이베어 대입하려면 형변환 연산자를 사용하여
                        //강제로 형변환해줘야한다. 이때 값은 손실이 없다는 전제하에 한다.
        byte k = -128;
//        byte l = k + 1; //Int -> byte 이므로 강제 형변환이 필요
        byte l = (byte) (k + 1);
        System.out.println(l);

        k = 127;
        l = (byte) (k + 1); //최대 최소값에서 1더하거나 빼게 되면 반대부호 최대값이 된다.
                                    //원형으로 돌게 되므로 결과 오류가 올 수 있다.
        System.out.println(l);

        int a = 200;
        byte b = (byte) a; //200 > 127 이므로 값이 손실이 발생하고 결과 오류 발생
    }
}
