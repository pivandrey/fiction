package library.fiction.dao;

import library.fiction.model.Book;

import java.util.List;

public interface BookDAO extends GenericDAO {
    List<Book> allBooks();

    Book addBook(Book book);

    Book getBookById(int id);

    void editBook(Book book);

    void deleteBook(Book book);
}
