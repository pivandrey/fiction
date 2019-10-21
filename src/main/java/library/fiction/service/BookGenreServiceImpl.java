package library.fiction.service;

import library.fiction.dao.BookAuthorDAO;
import library.fiction.dao.BookGenreDAO;
import library.fiction.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookGenreServiceImpl implements BookGenreService {
    @Autowired
    private BookGenreDAO bookGenreDAO;

    @Override
    @Transactional
    public List<BookGenre> getBookGenreList(Genre genre) {
        return bookGenreDAO.getBookGenreList(genre);
    }

    @Override
    @Transactional
    public List<BookGenre> getBookGenreList(Book book) {
        return bookGenreDAO.getBookGenreList(book);
    }

    @Override
    @Transactional
    public void addBookGenre(Genre genre, List<Book> books) {
        for (Book book : books) {
            BookGenre bookGenre = new BookGenre();
            bookGenre.setGenre_id(genre.getId());
            bookGenre.setBook_id(book.getId());
            bookGenreDAO.addBookGenre(bookGenre);
        }
    }

    @Override
    @Transactional
    public void addBookGenre(Book book, List<Genre> genres) {
        System.out.println("call addBookGenre");
        System.out.print("genre: ");
        System.out.println(genres);
        for (Genre genre : genres) {
            BookGenre bookGenre = new BookGenre();
            bookGenre.setGenre_id(genre.getId());
            bookGenre.setBook_id(book.getId());
            bookGenreDAO.addBookGenre(bookGenre);
        }
    }

    @Override
    @Transactional
    public void editBookGenre(Genre genre, List<Book> books) {
        deleteBookGenre(genre);
        addBookGenre(genre, books);
    }

    @Override
    @Transactional
    public void editBookGenre(Book book, List<Genre> genres) {
        deleteBookGenre(book);
        addBookGenre(book, genres);
    }

    @Override
    @Transactional
    public void deleteBookGenre(Genre genre) {
        List<BookGenre> bookGenreList = getBookGenreList(genre);

        for (BookGenre bookGenre : bookGenreList) {
            bookGenreDAO.deleteBookGenre(bookGenre);
        }
    }

    @Override
    @Transactional
    public void deleteBookGenre(Book book) {
        List<BookGenre> bookGenreList = getBookGenreList(book);

        for (BookGenre bookGenre : bookGenreList) {
            bookGenreDAO.deleteBookGenre(bookGenre);
        }
    }
}
