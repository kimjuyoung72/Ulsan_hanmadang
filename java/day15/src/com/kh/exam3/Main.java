package com.kh.exam3;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println(Objects.hashCode("씨앗")); //Objects.hashcode()는 객체의 해시코드를 반환
        System.out.println(Objects.hashCode("씨앗2")); //같은 내용은 같은 해시코드를 반환한다.
        System.out.println(Objects.hashCode("씨앗3"));
        System.out.println(Objects.hashCode("씨앗3"));
    }
}
