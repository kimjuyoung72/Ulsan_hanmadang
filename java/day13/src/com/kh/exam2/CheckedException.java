package com.kh.exam2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 checked exception : 컴파일 시점에 반드시 예외 처리해야하는 예외
* */
public class CheckedException {
    public static void main(String[] args) {
        // 1
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // 2
        try {
            Class cls = Class.forName("java.lang.Object");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // 3
        InputStreamReader in = new InputStreamReader(System.in);

        // 4
        try {
            FileInputStream fis = new FileInputStream("text.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // 5
        A a1 = new A();
        try {
            A a2 = (A) a1.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
