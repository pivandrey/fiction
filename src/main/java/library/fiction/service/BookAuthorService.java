package library.fiction.service;

import library.fiction.model.Author;
import library.fiction.model.Book;
import library.fiction.model.BookAuthor;

import java.util.List;

public interface BookAuthorService {
    List<BookAuthor> getBookAuthorList(Author author);

    List<BookAuthor> getBookAuthorList(Book book);

    void addBookAuthor(Author author, List<Book> books);

    void editBookAuthor(Author author, List<Book> books);

    void deleteBookAuthor(Author author);
}
