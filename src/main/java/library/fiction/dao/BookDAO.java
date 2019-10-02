package library.fiction.dao;

import library.fiction.model.Book;

import java.util.List;

public interface BookDAO {
    List<Book> allBooks();
    int addBook(Book book);
    Book getBookById(int id);
    void editBook(Book book);
}
