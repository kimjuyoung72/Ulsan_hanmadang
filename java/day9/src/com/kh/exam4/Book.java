package com.kh.exam4;

/*
    Static 사용 연습
    -bookId는 인스턴스 생성시 순차적으로 번호를 생성한다
    -ex) 001,002,003,,,999
    -bookId 는 인스턴스 별로 중복되지 않아야 한다.
*/
public class Book {

    private static int count;
    private String title;
    private String bookId;
    private final int BOOKID_SIZE = 3;

    public Book(String title) {
        this.title = title;
        count++;
        String tmp = count + "";
        int size = BOOKID_SIZE - tmp.length();

        for (int i = 0; i < size; i++) {
          tmp = "0" + tmp;
        }
        bookId = tmp;
    }

    public String getTitle() {
        return title;
    }

    public String getBookId() {
        return bookId;
    }

    public static int getCount() {
        return count;
    }
}
