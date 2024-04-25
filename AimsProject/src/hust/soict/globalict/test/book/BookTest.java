package AimsProject.src.hust.soict.globalict.test.book;

import AimsProject.src.hust.soict.globalict.aims.media.Book;

import java.util.Collections;

public class BookTest {
    public static void main(String[] args) {
        Book book = new Book();

        book.addAuthor("Hoang");
        book.addAuthor("Hoang");
        book.removeAuthor("Hoang");
        book.addAuthor("Hoang");

    }
}
