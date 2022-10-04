package com.kh.exam1;

//import java.lang.*;  //자동으로 적용됨

//public class Person extends Object{ 기본적으로 최상위 포함
public class Person {
    //member field
    private final int MINAGE = 0;
    private final int MAXAGE = 150;
    private String name;
    private int age;
    private Gender gender;
    //creator
    public Person() {  //상위 개념의 디폴트 생성자 호출
        super();
    }

    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person(String name) {

        this(name, 1, Gender.FEMALE);
        //this()는 자신의 생성자 호출, super()는 같이 올 수 없다.
        //따라서 이 단계에서 Object 생성자를 호출하지 않지만
        //Person(String name, int age, Gender gender)을 호출하고
        //super(); 실행.
    }

    public Person(int age, Gender gender) {
//        this.name = "아무개";
//        this.age = age;
//        this.gender = gender;
        this("아무개", age, Gender.FEMALE);
    }

    public Person(String name, Gender  gender) {

        this.name = name;
        this.age = 1;
        this.gender = gender;
    }
    //member method
    public void smile() {
        System.out.println("하하");
    }
    public void eat() {
        System.out.println("냠냠");
    }

    public String getName() {
        String str = "";
        str = name.substring(1);
        return str;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= MINAGE && age <= MAXAGE) {
            this.age = age;
        }
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        String str = "";
        str += "이름 : " + this.name + "\n";
        str += "나이 : " + this.age + "\n";
        str += "성별 : " + this.gender + "\n";
        return str;
    }
}
