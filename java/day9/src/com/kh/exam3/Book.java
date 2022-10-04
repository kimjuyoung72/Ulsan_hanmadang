package com.kh.exam3;
/*
    Static 사용 연습
    -bookId는 인스턴스 생성시 순차적으로 번호를 생성한다
    -bookId 는 인스턴스 별로 중복되지 않아야 한다.
*/
public class Book {

    private static int count ;
    private String title;
    private int bookId;

    public Book(String title) {
        this.title = title;
        this.bookId = ++count;

//        count = getBookId() + 1;
//        this.bookId = count;
    }

    public String getTitle() {
        return title;
    }

    public int getBookId() {
        return bookId;
    }

    public static int getCount() {
        return count;
    }
}
