package com.kh.exam5;

import java.util.Arrays;
import java.util.Scanner;

public class CarMain {
    public static void main(String[] args) {

        Car[] cars = new Car[3];
        Scanner scanner = new Scanner(System.in);

        boolean stop = false;
        do {
            System.out.println("메뉴] 1.차량구매/입고 2.차고지 출고 3.차고지현황 4.종료");
            System.out.println("선택 >> ");
            String inputcolor = scanner.nextLine();

            switch (Integer.parseInt(inputcolor)){
                case 1:
                    System.out.println("원하는 차량 색상은 : ");
                    inputcolor = scanner.nextLine();

                    int i;
                    boolean flag = false;
                    for ( i = 0; i < cars.length; i++) {
                        if (cars[i] == null) {
                            cars[i] = new Car(inputcolor);
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.println("여유 공간이 부족합니다.");
                       // stop = true;
                    } else {
                        System.out.println(i+"번째 차고지에 입고완료!");
                        System.out.println(Arrays.toString(cars));
                    }
                    break;
                case 2: //출고
                    System.out.println("출고할 차량 색상");
                    String coloOfCar = scanner.nextLine();
                    boolean finded = false;
                    for (int j = 0; j < cars.length; j++) {
                        if (cars[j].getColor().equals(coloOfCar)) {
                            cars[j] = null;
                            finded = true;
                            break;
                        }
                    }
                    if (!finded) {
                        System.out.println("출고하고자 하는 차량이 없습니다.");
                        continue;
                    }
                    break;
                    }
        } while (!stop);

        for (Car c : cars) {
            if(c == null) continue;
            System.out.println(c.getColor());
        }
    }
}
