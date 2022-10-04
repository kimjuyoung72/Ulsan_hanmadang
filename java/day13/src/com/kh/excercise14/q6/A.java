package com.kh.excercise14.q6;

public class A {
    void abc() {
        bcd();
    }

    private void bcd() {
        try {
            Thread.sleep(1000);
            Class.forName("java.lang.Object");
        } catch (InterruptedException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
