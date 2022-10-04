package com.kh.exam1;

import java.util.ArrayList;
import java.util.List;

public class ListExam {
    public static void main(String[] args) {
        //컬렉션 생성
        List<String> list = new ArrayList<String>(); //List 계열의 <String>타입을 담는 ArrayList 생성
//        List<String> list = new ArrayList<String>(30); //공간 용량 지정 가능. 디폴트 10.
        System.out.println(list.size()); //요소의 수

        //요소 추가(컬렉션 마지막에)
        boolean flag1 = list.add("홍길동");
        list.add("홍길순");
        list.add("홍길서");
        list.add("홍길동"); //중복허용
        System.out.println(list);

        System.out.println("=====================");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("=====================");
        //요소 순환(향상된 for문)
        for (String ele: list) {
            System.out.println(list);
        }
        System.out.println("=====================");


        //요소 추가(원하는 인덱스에)
        list.add(1,"홍길남");
        System.out.println(list);

        //요소 교체(원하는 인덱스에)
        list.set(3, "홍길북");
        System.out.println(list);

        //요소 검색
        System.out.println(list.contains("홍길동")); //찾는 요소가 있는지
        //요소 검색(특정 인덱스 요소 반환)
        System.out.println(list.get(2));
        //요소 검색(컬렉션이 비어 있는지)
        System.out.println(list.isEmpty());
        //요소 검색(요소 수 반환)
        System.out.println(list.size());

        //요소 삭제(특정 인덱스의)
        list.remove(1);
        System.out.println(list);
        //요소 삭제(특정 요소)
        list.remove("홍길북");
        System.out.println(list);
        //요소 삭제(전체)
        list.clear();
        System.out.println(list.size());



    }
}
