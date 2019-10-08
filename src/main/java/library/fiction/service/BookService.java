package library.fiction.service;

import library.fiction.model.Book;

import java.util.List;

public interface BookService {
    List<Book> allBooks();

    List<Book> getBooksById(int[] booksIds);

    Book createBook(Book book, int[] authorIds, int[] genreIds);

    Book getBookById(int id);

    void editBook(Book book, int[] authorIds, int[] genreIds);

    void deleteBook(Book book);
}
