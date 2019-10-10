package library.fiction.dao;

import library.fiction.model.Book;
import library.fiction.model.BookGenre;
import library.fiction.model.Genre;

import java.util.List;

public interface BookGenreDAO {
    List<BookGenre> getBookGenreList(Genre genre);

    List<BookGenre> getBookGenreList(Book book);

    void addBookGenre(BookGenre bookGenre);

    void deleteBookGenre(BookGenre bookGenre);
}
