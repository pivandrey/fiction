package library.fiction.dao;

import library.fiction.model.Author;
import library.fiction.model.Book;
import library.fiction.model.BookAuthor;

import java.util.List;

public interface BookAuthorDAO {
    List<BookAuthor> getBookAuthorList(Author author);

    List<BookAuthor> getBookAuthorList(Book book);

    void addBookAuthor(BookAuthor bookAuthor);

    void deleteBookAuthor(BookAuthor bookAuthor);
}
