package com.kh.exam1;

public class Book {
    //멤버
    //멤버 필드
    //인스턴스 멤버 필드
    String title;
    //정적 멤버 필드
    static int bookId;
    public Book(String title) {
        super();
        this.title = title;
    }
    //멤버 메소드
    //인스턴스 멤버 메소드 : 인스턴스 멤버, 정적 멤버 모두 사용 가능
    public String getTitle() { //인스턴스 메소드
        return this.title;  //인스턴스 멤버
    }

    public int getBookId() { //인스턴스 메소드
        return bookId; //정적 멤버
    }
//    public static String getTitle2() { //정적 메소드
//        return this.title; //인스턴스 멤버 -> 오류
//    }
    //정적 멤버 메소드 : 정적 멤버만 사용 가능
    public static int getBookId2() { //정적 메소드
        return bookId;  //정적 멤버
    }
}
