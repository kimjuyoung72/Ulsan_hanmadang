package com.kh.exam3;

import java.util.Objects;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
//
    @Override
    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Person)) return false;
//        Person person = (Person) o;
//        return age == person.age && Objects.equals(name, person.name);
        System.out.println("equals()호출됨");
        if (o instanceof Person) {
            Person p = (Person) o;
//            if (this.name.equals(p.name) && this.age == p.age) { //둘다 같다면
            if (this.name.equals(p.name)) { //이름만 같다면
                return true;
            }
        }
        return false;
    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hashCode(name) + age;
//    }


    @Override
    public int hashCode() {
        System.out.println("hash()호출됨");
//        return Objects.hash(name, age); //둘다 같다면
        return Objects.hash(name); //이름만 같다면
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
