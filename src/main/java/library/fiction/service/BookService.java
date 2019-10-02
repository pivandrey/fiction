package library.fiction.service;

import library.fiction.model.Book;

import java.util.List;

public interface BookService {
    List<Book> allBooks();
    int addBook(Book book);
    Book getBookById(int id);
    void editBook(Book book);
}
