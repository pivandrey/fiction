package library.fiction.service;

import library.fiction.model.Author;
import library.fiction.model.Book;
import library.fiction.model.BookAuthor;

import java.util.List;

public interface BookAuthorService {
    List<BookAuthor> getBookAuthorList(Author author);

    List<BookAuthor> getBookAuthorList(Book book);

    void addBookAuthor(Author author, List<Book> books);

    void addBookAuthor(Book book, List<Author> authors);

    void editBookAuthor(Author author, List<Book> books);

    void editBookAuthor(Book book, List<Author> authors);

    void deleteBookAuthor(Author author);

    void deleteBookAuthor(Book book);
}
