package com.kh.exam1;

public class CarMain {
    public static void main(String[] args) {
        Car car = new Car("white", "2000cc", "현대");    //실체화, 인스턴스화
        Car car1 = new Car("red", "2500cc", "bmw");
        Car car2 = new Car("black","3000cc","benz");

        car.start();
        car.run();

        car1.start();
        car1.run();

        car2.start();
        car2.run();
        car2.stop();
    }
}
