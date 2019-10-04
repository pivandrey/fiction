package library.fiction.service;

import library.fiction.dao.BookDAO;
import library.fiction.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookDAO bookDAO;

    @Autowired
    public void setBookDAO(BookDAO bookDAO) { this.bookDAO = bookDAO; }

    @Override
    @Transactional
    public List<Book> allBooks() {
        return bookDAO.allBooks();
    }

    @Override
    @Transactional
    public int addBook(Book book) {
        return bookDAO.addBook(book);
    }

    @Override
    @Transactional
    public Book getBookById(int id) {
        return bookDAO.getBookById(id);
    }

    @Override
    @Transactional
    public void editBook(Book book) {
        bookDAO.editBook(book);
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
}
