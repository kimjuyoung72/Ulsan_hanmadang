package com.kh.exam3;

public class CarMain {
    public static void main(String[] args) {
        Car car1 = new Car("Ceramic blue");
       // System.out.println(car1.getId());
        Car car2 = new Car("Magenta");
      //  System.out.println(car2.getId());
        Car car3 = new Car("Red");
      //  System.out.println(car3.getId());

        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);

        System.out.println(Car.getCount());
    }
}
