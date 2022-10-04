package com.kh.exam4;
//import java.lang.*;  디폴트로 반영되기에 생략
public class Person {//생략 extends Object{
                                        //Object는 최상위 조상. 뿌리
    String name;
    int age;
    String gender;
    //
//    public Person() {
//        super();
//    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    //
    public void smile() {

    }
    public void eat(){

    }
}
