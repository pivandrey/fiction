package library.fiction.service;

import library.fiction.model.Book;

import java.util.List;

public interface BookService {
    List<Book> allBooks();

    List<Book> getBooksById(int[] booksIds);

    Book createBook(Book book);

    Book getBookById(int id);

    void editBook(Book book);

    void deleteBook(Book book);
}
