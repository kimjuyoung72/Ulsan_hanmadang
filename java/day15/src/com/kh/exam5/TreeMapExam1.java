package com.kh.exam5;

import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapExam1 {
    public static void main(String[] args) {

        TreeMap<Integer, String> scores = new TreeMap<>();
        scores.put(87, "홍길동1");
        scores.put(98, "홍길동2");
        scores.put(75, "홍길동3");
        scores.put(95, "홍길동4");
        scores.put(80, "홍길동5");
        System.out.println(scores);
        System.out.println(scores.descendingMap());
        System.out.println(scores.descendingKeySet());

        Map.Entry<Integer, String> entry = scores.firstEntry();
        System.out.println(entry.getKey() + ":" + entry.getValue());
        entry = scores.lastEntry();
        System.out.println(entry.getKey() + ":" + entry.getValue());

        entry = scores.higherEntry(95);
        System.out.println(entry.getKey() + ":" + entry.getValue());
        entry = scores.lowerEntry(95);
        System.out.println(entry.getKey() + ":" + entry.getValue());
        entry = scores.ceilingEntry(95);
        System.out.println(entry.getKey() + ":" + entry.getValue());
        entry = scores.floorEntry(95);
        System.out.println(entry.getKey() + ":" + entry.getValue());
//
//        while (!scores.isEmpty()) {
//            entry = scores.pollFirstEntry();
//            System.out.println(entry.getKey() + ":" + entry.getValue() + ":" + scores.size());
//
//        }
//
        //검색
        SortedMap<Integer, String>  subMap = scores.subMap(80, 90);
        System.out.println(subMap);
        subMap = scores.subMap(80, false, 90, true);
        System.out.println(subMap);

        System.out.println(scores.headMap(80,true));
        System.out.println(scores.tailMap(80,false));

//        NavigableMap<Integer, String> integerStringNavigableMap = scores.descendingMap();
        //맵을 내림차순하여 정렬된 객체 반환.
        System.out.println(scores.descendingMap());
        //맵키를 내림차순하여 정렬된 객체 반환
        System.out.println(scores.descendingKeySet());
    }
}
