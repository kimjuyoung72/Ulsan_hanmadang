package com.kh.excercise14.q7;

public class A {
    void abc(double score) throws ScoreException {
        if (score >= 3.0) {
            System.out.println("장학금~");
        } else {
            throw new ScoreException("놀았냐!?");
        }
    }
}
