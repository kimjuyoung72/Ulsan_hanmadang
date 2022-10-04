package com.kh.exam1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[]  arr = new int[3];

        System.out.println(Arrays.toString(arr));

        try { //오류 예상 코드
            arr[3] = 10; //4번째 방이 존재하지 않으므로 실행 시 ArrayIndexOutOfBoundsException 예외 발생
        } catch (ArrayIndexOutOfBoundsException e) { //예외 처리
//            e.getStackTrace();
            //e.printStackTrace(); //오류 설명
            System.out.println("범위 초과");
        }
        finally { //오류 여부와 상관없이 실행되는 블럭. 생략가능
            System.out.println("finally 블럭 실행됨");
        }
    }
}
