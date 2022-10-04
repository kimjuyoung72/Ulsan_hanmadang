package com.kh.exam4;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class PersonMain {
    public static void main(String[] args) {
        Person p1 = new Person("홍길동1", 20);
        Person p2 = new Person("홍길동2", 40);
        Person p3 = new Person("홍길동3", 30);
        Person p4 = new Person("홍길동4", 10);
        Set<Person> set = new TreeSet<>();
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        System.out.println(set);

        Comparator comp1 = new Comparator<Person>() { //익명생성
            @Override //컬렉션 생성시 비교연산자를 교체해서 적용가능.
            public int compare(Person o1, Person o2) {
                int result = 0;
                if (o1.getAge() < o2.getAge()) {
                    result = 1;
                } else if (o2.getAge() < o1.getAge()) {
                    result = -1;
                }
                return result;
            }
        }; //인터페이스에 메소드가 하나만 있으면 람다식으로 표현가능.
//        Set<Person> set1 = new TreeSet<>(
//
//            (Person o1, Person o2) ->{
//                int result = 0;
//                if (o1.getAge() < o2.getAge()) {
//                    result = 1;
//                } else if (o2.getAge() < o1.getAge()) {
//                    result = -1;
//                }
//                return result;
//            }
//        });

        Set<Person> set1 = new TreeSet<>(comp1);
        set1.add(p1);
        set1.add(p2);
        set1.add(p3);
        set1.add(p4);
        System.out.println(set1);
    }
}
