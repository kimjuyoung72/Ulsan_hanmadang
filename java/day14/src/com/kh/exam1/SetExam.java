package com.kh.exam1;

import java.util.HashSet;
import java.util.Set;

public class SetExam {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();

        //요소 추가
        set.add("홍길동");
        set.add("홍길순");
        set.add("홍길서");
        set.add("홍길동"); //중복 체크. 덮어 씌운다
        System.out.println(set);

        //요소 검색(동등객체 존재유무판단
        System.out.print("홍길동 있냐? ");
        System.out.println(set.contains("홍길동"));

        //요소 검색(요소 수)
        System.out.print("요소 수 : ");
        System.out.println(set.size());

        //요소 순환(인덱스가 없으므로..)
        for (String ele : set) {
            System.out.println(ele);
        }

        //요소 삭제(등등객체 삭제)
        set.remove("홍길서");
        System.out.println(set);

        //요소 삭제(전체)
        set.clear();
        System.out.println(set.size());

    }
}
