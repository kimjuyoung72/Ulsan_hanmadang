package com.kh.excercise14.q7;

public class Main {
    public static void main(String[] args) { //throws ScoreException {
        A a = new A();
        try {
            a.abc(3.8);
            a.abc(1.8);

        } catch (ScoreException e) {
            System.out.println(e.getMessage());
        }
    }
}
