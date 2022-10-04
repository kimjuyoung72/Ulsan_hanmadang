package com.kh.exam1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExam {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();

        //요소 추가(키, 값)
        dictionary.put("student", "학생");
        dictionary.put("teacher", "교사");
        dictionary.put("lecture", "강좌");
        dictionary.put("classroom", "교실");
        System.out.println(dictionary);

        //요소 검색(키 존재여부)
        System.out.println(dictionary.containsKey("student"));
        System.out.println(dictionary.containsKey("student1"));
        //                  (값 존재여부)
        System.out.println(dictionary.containsValue("학생"));
        System.out.println(dictionary.containsValue("학생1"));
        //                  (키로 값 반환)
        System.out.println(dictionary.get("student"));
//        System.out.println(dictionary.get("student1"));
        //                  (모든 키 반환)
        System.out.println("---------------------------------------------------------------");
        Set<String> set = dictionary.keySet();
        for (String ele : set) {
            System.out.println(ele);
        }
        System.out.println(dictionary.keySet());
        System.out.println("---------------------------------------------------------------");
        //                  (모든 값 반화)
        Collection<String> values = dictionary.values();
        for (String ele : values) {
            System.out.println(ele);
        }
        System.out.println(dictionary.values());
        System.out.println("---------------------------------------------------------------");
        //                  (키와 값의 쌍으로 구성된 Map.Entry 반환)
        Set<Map.Entry<String, String>> entries = dictionary.entrySet();
        for (Map.Entry<String ,String> ele:entries
             ) {
            System.out.println(ele.getKey() + " : " + ele.getValue());
        }
        System.out.println(entries);
        System.out.println("---------------------------------------------------------------");
        //                  (요소가 비어 있는지 검색)
        System.out.println(dictionary.isEmpty());
        //                  (요소 수)
        System.out.println(dictionary.size());


        //요소 삭제(키로)
        dictionary.remove("student");
        System.out.println(dictionary);
        //                  (키와 값으로)
        dictionary.remove("teacher", "교사");
        System.out.println(dictionary);
        //                  (전체)
        dictionary.clear();
        System.out.println(dictionary.size());

    }
}
