package library.fiction.service;

import library.fiction.model.Book;
import library.fiction.model.BookGenre;
import library.fiction.model.Genre;

import java.util.List;

public interface BookGenreService {
    List<BookGenre> getBookGenreList(Genre genre);

    List<BookGenre> getBookGenreList(Book book);

    void addBookGenre(Genre genre, List<Book> books);

    void addBookGenre(Book book, List<Genre> genres);

    void editBookGenre(Genre genre, List<Book> books);

    void editBookGenre(Book book, List<Genre> genres);

    void deleteBookGenre(Genre genre);

    void deleteBookGenre(Book book);
}
