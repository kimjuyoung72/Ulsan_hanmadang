package com.kh.exam3;

public class BookMain {
    public static void main(String[] args) {
        Book b1 = new Book("제목1");
        Book b2 = new Book("제목2");
        Book b3 = new Book("제목3");

        System.out.println(b1.getBookId());
        System.out.println(b2.getBookId());
        System.out.println(b3.getBookId());

        //최근 bookId 정보 추적
        System.out.println(Book.getCount());
    }
}
