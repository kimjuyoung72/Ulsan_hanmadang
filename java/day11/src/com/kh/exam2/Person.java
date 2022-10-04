package com.kh.exam2;

public class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
//        return super.equals(obj);
        if (this == obj) {
            return true;
        }
        if(obj instanceof Person) {
            Person p = (Person) obj;
            return (this.age == p.age);
        }
        return false;
    }
}
