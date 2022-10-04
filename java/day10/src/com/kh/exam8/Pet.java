package com.kh.exam8;

// 실습과제 10.1: Pet.java
// 애완동물을 모델한다

public class Pet {
    private String name;    // 이름
    private int age;        // 나이

    // 애완동물의 이름과 나이를 각각 기본 값으로 초기화하면서
    // Pet 객체를 생성한다
    public Pet() {
        super();
        this.name = "";
        this.age = 0;
    }

    // 애완동물의 이름과 나이를 각각 주어진 값으로 초기화하면서
    // Pet 객체를 생성한다
    public Pet(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    // 애완동물의 이름을 변경한다
    public void setName(String newName) {
        System.out.println(this.name + "이름을 " + newName + "으로 변경합니다.");
        this.name = newName;
    }

    // 애완동물의 나이를 변경한다
    public void setAge(int newAge) {
        if (this.age != newAge) {
            System.out.println(this.name + "나이를 " + this.age + "살에서 " + newAge + "살로 변경합니다.");
            this.age = newAge;
        }
    }

    // 애완동물의 이름을 알려 준다
    public String getName() {
        // 여기에 코드를 입력하세요
        return this.name;
    }
    // 애완동물의 나이를 알려 준다
    public int getAge() {
        return this.age;
    }
    // 애완동물의 이름과 나이를 알려 준다
    @Override
    public String toString() {
    //    System.out.println("이름: " + this.name);
        // 여기에 코드를 입력하세요
        return "이름 : " + this.name + ", 나이 : " + this.age;
    }
}