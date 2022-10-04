package com.kh.exam4;

public class BookMain2 {
    public static void main(String[] args) {
        Book[] books = new Book[5];
        books[0] = new Book("제목1");
        books[1] = new Book("제목2");
        books[2] = new Book("제목3");
        books[3] = new Book("제목4");
        books[4] = new Book("제목5");

        books[0] = null;

                //책 제목으로 책 검색하기
        Book foundBook = searchBook(books,"제목3");
        System.out.println(foundBook.getTitle());
    }

    //책 제목을 입력받아 책을 반환하는 메소드 정의
    public static Book searchBook(Book[] books, String title) {
        Book foundBook = null;

        for (int i = 0; i < books.length; i++) {

            if (books[i] == null) {
                continue;
            }
            String subject = books[i].getTitle();
            if (subject.equals(title)) {
                foundBook = books[i];
                break;
            }
        }
        return foundBook;
    }
}
