package com.kh.exam3;

public class Car {
    private int id; //식별번호, 인스턴스시 1씩 증가
    private static int count;
    private String color;

    public Car(String color) {
        this.color = color;
        id = ++count;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' + ", Id=" + id +
                '}';
    }
}
