package com.kh.pdata;

import lombok.*;

//@Getter
//@Setter
@NoArgsConstructor //매개값 없는 생성자
@AllArgsConstructor//매개값 있는 생성자
//@ToString
//@EqualsAndHashCode

@Data //getter, setter, tostring, equalandhashcode

public class Person extends Object{
   private String name;
   private int age;

//   public Person(){
//      super();
//   }

//   public Person(String name, int age) {
//      this.name = name;
//      this.age = age;
//   }

//   public String getName() {
//      return name;
//   }
//
//   public void setName(String name) {
//      this.name = name;
//   }
//
//   public int getAge() {
//      return age;
//   }
//
//   public void setAge(int age) {
//      this.age = age;
//   }


//   @Override
//   public String toString() {
//      return "Person{" +
//            "name='" + name + '\'' +
//            ", age=" + age +
//            '}';
//   }

//   @Override
//   public boolean equals(Object o) {
//      if (this == o) return true;
//      if (o == null || getClass() != o.getClass()) return false;
//      Person person = (Person) o;
//      return age == person.age && name.equals(person.name);
//   }
//
//   @Override
//   public int hashCode() {
//      return Objects.hash(name, age);
//   }
}
