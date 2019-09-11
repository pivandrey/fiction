package library.fiction.service;

import library.fiction.dao.LibraryDAO;
import library.fiction.dao.LibraryDAOIml;
import library.fiction.model.Author;
import library.fiction.model.Book;
import library.fiction.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    private LibraryDAO libraryDAO;

    @Autowired
    public void setLibraryDAO(LibraryDAO libraryDAO) {
        this.libraryDAO = libraryDAO;
    }

    @Override
    @Transactional
    public List<Author> allAuthors() {
        return libraryDAO.allAuthors();
    }

    @Override
    @Transactional
    public List<Book> allBooks() {
        return libraryDAO.allBooks();
    }

    @Override
    @Transactional
    public List<Genre> allGenres() {
        return libraryDAO.allGenres();
    }

    @Override
    @Transactional
    public void addAuthor(Author author) {
        libraryDAO.addAuthor(author);
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        libraryDAO.addBook(book);
    }

    @Override
    @Transactional
    public void addGenre(Genre genre) {
        libraryDAO.addGenre(genre);
    }

    @Override
    @Transactional
    public Author getAuthorById(int id) {
        return libraryDAO.getAuthorById(id);
    }

    @Override
    @Transactional
    public Book getBookById(int id) {
        return libraryDAO.getBookById(id);
    }

    @Override
    @Transactional
    public Genre getGenreById(int id) {
        return libraryDAO.getGenreById(id);
    }

    @Override
    @Transactional
    public void editAuthor(Author author) {
        libraryDAO.editAuthor(author);
    }

    @Override
    @Transactional
    public void editBook(Book book) {
        libraryDAO.editBook(book);
    }

    @Override
    @Transactional
    public void editGenre(Genre genre) {
        libraryDAO.editGenre(genre);
    }
}
