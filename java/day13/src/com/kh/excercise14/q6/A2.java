package com.kh.excercise14.q6;

public class A2 {
    void abc() {

        try {
            bcd();
        } catch (InterruptedException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void bcd() throws InterruptedException, ClassNotFoundException {

            Thread.sleep(1000);
            Class.forName("java.lang.Object");
    }
}
