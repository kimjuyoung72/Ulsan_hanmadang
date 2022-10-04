package com.kh.exam8;

// 실습과제 10.1: Dog.java
// 개를 모델한다

public class Dog extends Pet {
    private String breed;			// 품종
    private boolean boosterShot;	// 예방주사 접종여부

    // 개의 이름, 나이와 품종을 각각 기본 값으로 초기화하고
    // 예방주사 접종여부는 false로 초기화하면서 Dog 객체를 생성한다
    public Dog()
    {
        super();
        this.breed = "시고르자브";
        this.boosterShot = false;
    }

    // 개의 이름, 나이, 품종을 각각 주어진 값으로 초기화하고
    // 예방주사 접종여부는 false로 초기화하면서 Dog 객체를 생성한다
    public Dog(String name, int age, String breed)
    {
//        super.setName(name);
//        super.setAge(age);
        super(name,age);
        setBreed(breed);
        this.boosterShot = false;
    }

    // 개의 모든 데이터를 알려 준다
    public String toString()
    {
        String str = "";
        if (this.boosterShot) {
            str = "맞음";
        } else {
            str = "안맞음";
        }
        return "이름 : " + super.getName() + ", 나이 : " + super.getAge()
                + ", 품종 : " + this.breed + ", 예방접종 : " + str;
    }

    // 개의 품종을 변경한다
    public void setBreed(String newBreed)
    {
        if(!newBreed.equals(this.breed)) {
            System.out.println("품종을 " + newBreed + "로 변경합니다.");
            this.breed = newBreed;
        }
    }

    // 개의 예방주사 접종여부를 변경한다
    public void setBoosterShot(boolean boosterShot) {
//        if(boosterShot) {
//            System.out.println(super.getName() + "가 예방접종을 마쳤습니다.");
//        }
        this.boosterShot = boosterShot;
    }

    // 개의 품종을 알려 준다
    public String getBreed()
    {
        return this.breed;
    }

    // 개의 예방주사 접종여부를 알려 준다
    public boolean isBoosterShot() {
        return boosterShot;
    }

}