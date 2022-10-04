package com.kh.exam2;

public class TraineeMain {
    public static void main(String[] args) {
        Trainee trainee = new Trainee();
        trainee.study();
        trainee.doHomeWork();

        Trainee trainee1 = new Trainee("길동이", 36);
        trainee1.study();
        trainee1.doHomeWork();

        Trainee trainee2 = new Trainee("아무개", 23, "수컷");
        trainee2.study();
        trainee2.doHomeWork();

        Trainee[] trainees = new Trainee[21];
        trainees[0] = trainee;
        trainees[1] = trainee1;
        trainees[2] = trainee2;

        for (Trainee t : trainees) {
            t.study();
        }
    }
}
