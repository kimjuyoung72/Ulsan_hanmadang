package com.kh.exam1;

public class StringExam {
    public static void main(String[] args) {
        //값 비교 ==
        int x = 10, y = 20, z = 30;
        System.out.println(x == y);
        System.out.println(x == z);

        //참조타입 값비교(힙 메모리 참조하는 주소) ==
        printLine('=', 12);
        String name1 = "홍길동";
        String name2 = "홍길동"; //값으로 초기화할때 같은 값이 있으
        String name3 = "홍길순"; //면 새로 만들지 않고 기존 것 사용.
        System.out.println(name1 == name2); //참조타입은 값이 아닌 주소를 비교
        System.out.println(name1 == name3);
        printLine('=', 12);

        String name4 = new String("홍길동"); //값이 같아도 객체로 생성하면
        String name5 = new String("홍길동"); //다른 주소 참조값을 갖는다.
        String name6 = new String("홍길순");
        System.out.println(name4 == name5);  //주소 비교
        System.out.println(name4 == name6); //따라서 참조값 자체가 같은지 따질때는
                                                                            //equals()를 사용.
        printLine('=',12);

        //Object.equals() : 인스턴스간 내용비교 용도
        //String.equals() : 인스턴스가 가지고 있는 문자열이 같은지 비교
        System.out.println(name4.equals(name5));
        System.out.println(name4.equals(name6));


    }

    public static void printLine(char ch, int cnt) {
        for (int i = 0; i < cnt; i++) {
            System.out.print(ch);
        }
        System.out.println();
    }
}
