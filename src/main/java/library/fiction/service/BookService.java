package library.fiction.service;

import library.fiction.model.Book;

import java.util.List;

public interface BookService {
    List<Book> allBooks();
    void addBook(Book book);
    Book getBookById(int id);
    void editBook(Book book);
}
