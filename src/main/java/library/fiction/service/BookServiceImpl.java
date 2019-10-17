package library.fiction.service;

import library.fiction.dao.BookDAO;
import library.fiction.model.Author;
import library.fiction.model.Book;
import library.fiction.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookDAO bookDAO;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookAuthorService bookAuthorService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private BookGenreService bookGenreService;

    @Autowired
    public void setBookDAO(BookDAO bookDAO) { this.bookDAO = bookDAO; }

    @Override
    @Transactional
    public List<Book> allBooks() {
        return bookDAO.allBooks();
    }

    @Override
    @Transactional
    public List<Book> getBooksById(int[] bookIds) {
        List<Book> books = new ArrayList<>();
        for (int bookId : bookIds) {
            Book book = bookDAO.getBookById(bookId);
            books.add(book);
        }
        return books;
    }

    @Override
    @Transactional
    public Book createBook(Book book, int[] authorIds, int[] genreIds) {
        List<Author> authors = authorService.getAuthorsById(authorIds);
        List<Genre> genres = genreService.getGenresById(genreIds);
        Book createdBook = bookDAO.addBook(book);
        bookGenreService.addBookGenre(createdBook, genres);
        bookAuthorService.addBookAuthor(createdBook, authors);
        return createdBook;
    }

    @Override
    @Transactional
    public Book getBookById(int id) {
        System.out.println("Get book from DAO");
        return bookDAO.getBookById(id);
    }

    @Override
    @Transactional
    public void editBook(Book book, int[] authorIds, int[] genreIds) {
        List<Author> authors = authorService.getAuthorsById(authorIds);
        List<Genre> genres = genreService.getGenresById(genreIds);
        bookAuthorService.editBookAuthor(book, authors);
        bookGenreService.editBookGenre(book, genres);
        book.setAuthors(authors);
        book.setGenres(genres);
        bookDAO.editBook(book);
    }

    @Override
    @Transactional
    public void deleteBook(Book book) {
        bookAuthorService.deleteBookAuthor(book);
        bookGenreService.deleteBookGenre(book);
        bookDAO.deleteBook(book);
    }
}
