package com.kh.exam1;

import java.util.HashSet;
import java.util.Set;

public class SetExam2 {
    public static void main(String[] args) {
        Set<Integer> setA = new HashSet<>(); //만약 기본타입을 다루고 싶다면
        Set<Integer> setB = new HashSet<>(); //Wrapper class를 사용

        Integer i1 = 1; //unboxing

        setA.add(1);setA.add(2);setA.add(3);setA.add(4);
        setB.add(3);setB.add(4);setB.add(5);setB.add(6);

        //합집합
//        setA.addAll(setB);
//        System.out.println(setA); //1,2,3,4,5
//
        //차집합
//        setA.removeAll(setB);
//        System.out.println(setA); //1,2

        //교집합
//        setA.retainAll(setB);
//        System.out.println(setA); //3.4


    }
}
