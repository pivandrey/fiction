package library.fiction.service;

import library.fiction.model.Author;
import library.fiction.model.Book;
import library.fiction.model.Genre;

import java.util.List;

public interface LibraryService {
    List<Author> allAuthors();
    List<Book> allBooks();
    List<Genre> allGenres();
    void addAuthor(Author author);
    void addBook(Book book);
    void addGenre(Genre genre);
    Author getAuthorById(int id);
    Book getBookById(int id);
    Genre getGenreById(int id);
    void editAuthor(Author author);
    void editBook(Book book);
    void editGenre(Genre genre);
}
