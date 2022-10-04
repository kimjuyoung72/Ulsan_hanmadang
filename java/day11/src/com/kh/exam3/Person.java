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

    @Override
    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false; //생성되지 않았거나 클래스 타입이 다르다면
//        Person person = (Person) o;
//        return age == person.age && Objects.equals(name, person.name);
//        =======================================================
//        if (o == null) return false;
//        if( !(o instanceof Person) ) return false;
//        ---------------------------------------------------------------------------------------------------
        if (o == null || !(o instanceof Person)) return false;
//        Person p = (Person) o;
        return this.name.equals(((Person) o).name) && this.age == ((Person) o).age;
    }

}
