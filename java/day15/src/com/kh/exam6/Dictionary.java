package com.kh.exam6;

import java.util.HashMap;
import java.util.Map;

/*
* 싱글턴 패턴 : 인스턴스를 1개만 만들 수 있도록 하는 생성자 패턴.
* 1. 생성자의 접근 제한자 private
* 2. 인스턴스를 내부에서 생성하고 생성된 객체는 static
* 3. 공개된 메소드를 통해 내부에서 생성된 인스턴스를 반환.
*   (외부에서 인스턴스를 생성하지 않고 접근할 수 있도록 static 멤버 메소드로 정의)
*
* */
public class Dictionary {
    private static Dictionary dictionary = new Dictionary();
    private Map<String,String> store = new HashMap<>();
    private Dictionary() { //private 외부에서 접근불가능.
        super();
    }
    public static Dictionary getDictionary() {
        return dictionary;
    }

    public Map<String, String> getStore() {
        return store;
    }

    @Override
    public String toString() {
        return "사전" + store;
    }
}
