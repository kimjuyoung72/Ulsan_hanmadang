package com.kh.exam4;

import java.util.Objects;

public class Person implements Comparable<Person>{ //객체 비교를 위해 인터페이스 구현
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

//    <<오름차순>>
//    비교대상 객체가 동일하면 0 반환
//    비교대상 객체보다 크면 1 반환
//    비교대상 객체보다 작으면 -1 반환
//    <<내림차순>>
//    비교대상 객체가 동일하면 0 반환
//    비교대상 객체보다 크면 -1 반환
//    비교대상 객체보다 작으면 1 반환
@Override
    public int compareTo(Person o) {
        int result = 0;
//        if (this.age < o.age) { //내림차순
//            return result = 1;
//        } else if (o.age < this.age) {
//            return result = -1;
//        }
        if (this.age > o.age) { //오름차순
            return result = 1;
        } else if (o.age > this.age) {
            return result = -1;
        }

        return result;
    }
}
