package com.kh.exam5;

import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetExam1 {
    public static void main(String[] args) {
        TreeSet<Integer> scores = new TreeSet<>();
        scores.add(87);
//        scores.add(new Integer(87))
        scores.add(98);
        scores.add(75);
        scores.add(95);
        scores.add(80);
        System.out.println(scores);

        Integer score = null;
        score = scores.first();

        System.out.println("가장 낮은 점수 : " + score);
        score = scores.last();
        System.out.println("가장 높은 점수 : " + score);
        score = scores.lower(87);
        System.out.println("87미만 점수 : " + score);
        score = scores.higher(87);
        System.out.println("87초과 점수 : " + score);
        score = scores.floor(87);
        System.out.println("87이상 점수 : " + score);
        score = scores.ceiling(87);
        System.out.println("87이하 점수 : " + score);

//        while (!scores.isEmpty()) {
//            score = scores.pollFirst(); //polllast();
//            System.out.println(score + "남은 객체 수 : " + scores.size());
//        }
        NavigableSet<Integer> integers = scores.descendingSet();
        System.out.println(integers);
        //범위 검색
        SortedSet<Integer> integers1 = scores.subSet(80, 95);
        System.out.println(integers1);
        SortedSet<Integer> integers2 = scores.subSet(80, true, 95,true);
        System.out.println(integers2);

        //오름차순에서 상위, 하위 그룹 가져오기.
        System.out.println(scores.headSet(80,true));
        System.out.println(scores.tailSet(80, false)); //80 포함하지 않는다.

        //내림차순하여 상위, 하위그룹 가져오기
        NavigableSet<Integer> scoresByDescending = scores.descendingSet();
        System.out.println(scoresByDescending.headSet(80,true));
        System.out.println(scoresByDescending.tailSet(80,false));

    }
}
