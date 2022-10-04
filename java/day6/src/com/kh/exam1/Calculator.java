package com.kh.exam1;

public class Calculator {

    private String color;
    private String maker;
    private boolean power;
    private double result;
//    public Calculator() { //디폴트 생성자 : 매개변수 정의 안된 생성자
//        super();          //개발자가 명시하지 않으면 컴파일러가 자동생성
//    }     //명시적으로 1개라도 생성자가 정의되면 디폴트 생성자는 자동
    //으로 만들어지지 않는다.

    public Calculator(String color) {
        this.color = color;
    }

    public Calculator(String color, String maker) {
        this.color = color;
        this.maker = maker;
    }

    public void plus(double x, double y) {
        if (!this.power) {
            System.out.println("파워 OFF 상태!");
            return;
        }
        this.result = x + y;
    }

    public void minus(double x, double y) {
        if (!this.power) {
            System.out.println("파워 OFF 상태!");
            return;
        }
        this.result = x - y;
    }

    public void powerOn() {
        this.power = true;
    }

    public void powerOff() {
        this.power = false;
    }

    public boolean isPower() {
        return this.power;
    }

//    public double getResult() {
//        return this.result;
//    }

    public String getColor() {
        return this.color;
    }

    public String getMaker() {
        return this.maker;
    }

    public double getResult() throws Exception {
        //파워가 꺼져있으면 예외 발생
        if (!this.power) {
            throw new Exception("파워 OFF 상태");
        }
        return this.result;
    }
}
