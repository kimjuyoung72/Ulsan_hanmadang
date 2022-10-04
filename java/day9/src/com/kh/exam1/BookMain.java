package com.kh.exam1;

public class BookMain {
    public static void main(String[] args) {
//        Book b1 = new Book("제목1");
//        Book b2 = new Book("제목2");
//
//        String title = b1.title;
//
//        int id = b1.bookId;
        int id2 = Book.bookId;
        id2 = 3;
        Book.bookId = id2;
        System.out.println(Book.bookId);
//        String title2 = Book.title; //오류, 인스턴스로 접근 가능.

    }
}
