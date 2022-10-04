package com.kh.exam8;

// 실습과제 10.1: DogDriver.java
// Dog 클래스를 시험한다

import java.util.*;

public class DogDriver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String shotAnswer;  // 예방주사 접종여부 입력값
        String dogName;    // 개 이름
        int dogAge;      // 개 나이
        String dogBreed;  // 개 품종
        boolean dogShot;  // 예방주사 접종여부

        int numberOfDogs = 2;
        Dog[] dogs = new Dog[numberOfDogs];
        // 개의 이름, 나이와 품종은 각각 기본 값으로 초기화하고
        // 예방주사 접종여부는 false로 초기화하면서 Dog 객체를 생성한다
        dogs[0] = new Dog();
        // 개의 이름을 '하루'로 정한다
        dogs[0].setName("하루");

        // 개의 나이를 세 살로 한다
        dogs[0].setAge(3);

        // 개의 품종을 '진돗개'로 한다
        dogs[0].setBreed("진돗개");

        // 개의 예방주사 접종여부를 true로 한다
        dogs[0].setBoosterShot(true);

        // 개의 이름을 입력 받는다
        System.out.print("개의 이름을 입력하세요: ");
        dogName = scan.nextLine();


        // 개의 나이를 입력 받는다
        System.out.print("개의 나이를 입력하세요: ");
        boolean stop = false;
        String str = "";
        dogAge = 0;
        while(!stop) {
            str = scan.nextLine();
            try {
                dogAge = Integer.parseInt(str);
                stop = true;
            } catch (NumberFormatException e) {
                System.out.print("다시 입력하시오: ");
            }
        }

        // 개의 품종을 입력 받는다
        System.out.print("개의 품종을 입력하세요: ");
        dogBreed = scan.nextLine();

        // 입력 받은 개의 이름, 나이와 품종을 반영하여 Dog 객체를 생성한다
        dogs[1] = new Dog(dogName,dogAge,dogBreed);

        // 개의 예방주사 접종여부를 ‘예’ 혹은 ‘아니오’로 입력 받는다
        System.out.print("예방주사를 맞았나요(예 혹은 아니오)?: ");
        String tmp = "";
        tmp = scan.nextLine();
        if (tmp.equals("예")) {
            dogs[1].setBoosterShot(true);
        } else {
            dogs[1].setBoosterShot(false);
        }
            // 개의 예방주사 접종여부 입력 값에 따라
            // 예방주사 접종여부를 적절하게 정한다
        if (!dogs[1].isBoosterShot()) {
            System.out.println("예방 접종을 하십시요.");
        }
        
        // 첫 번째 Dog 객체의 모든 데이터를 출력한다
        // 여기에 코드를 입력하세요
        System.out.println(dogs[0]);
        // 두 번째 Dog 객체의 모든 데이터를 출력한다
        System.out.println(dogs[1]);
        // 두 살이 넘었으나 예방주사를 맞지 않는 개의 이름과 나이를 출력한다
        for(int i = 0 ; i < dogs.length; i++) {
            if (!dogs[i].isBoosterShot()) {
                System.out.println();
                System.out.println("다음 개들은 두 살이 넘었으나 예방주사를 맞지 않았다: ");
                System.out.println("이름 : " + dogs[i].getName() + ", 나이 : " + dogs[i].getAge());
            }
        }

    }
}