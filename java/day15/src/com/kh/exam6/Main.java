package com.kh.exam6;

import java.util.Calendar;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Dictionary d1 = Dictionary.getDictionary();
        Dictionary d2 = Dictionary.getDictionary();
        System.out.println(d1 == d2);

//        Map map = d1.getStore();
//        map.put("student", "학생");
//        map.put("teacher", "교사");
        d1.getStore().put("student", "학생");
        d1.getStore().put("teacher", "교사");
        d2.getStore().put("clasroom", "교실");
        System.out.println(d1);

        //비교) 캘린더
        Calendar calendar1 = Calendar.getInstance(); //형태는 비슷하나 싱글턴패턴은 아니다.
        System.out.println(calendar1.getTime());
        Calendar calendar2 = Calendar.getInstance();
        System.out.println(calendar1 == calendar2);
        System.out.println(calendar1.hashCode());
        System.out.println(calendar2.hashCode());
    }
}
