package library.fiction.service;

import library.fiction.dao.BookAuthorDAO;
import library.fiction.model.Author;
import library.fiction.model.Book;
import library.fiction.model.BookAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookAuthorServiceImpl implements BookAuthorService {
    @Autowired
    private BookAuthorDAO bookAuthorDAO;

    @Override
    @Transactional
    public List<BookAuthor> getBookAuthorList(Author author) {
        return bookAuthorDAO.getBookAuthorList(author);
    }

    @Override
    @Transactional
    public List<BookAuthor> getBookAuthorList(Book book) {
        return bookAuthorDAO.getBookAuthorList(book);
    }

    @Override
    @Transactional
    public void addBookAuthor(Author author, List<Book> books) {
        for (Book book : books) {
            BookAuthor bookAuthor = new BookAuthor();
            bookAuthor.setAuthor_id(author.getId());
            bookAuthor.setBook_id(book.getId());
            bookAuthorDAO.addBookAuthor(bookAuthor);
        }
    }

    @Override
    @Transactional
    public void addBookAuthor(Book book, List<Author> authors) {
        for (Author author : authors) {
            BookAuthor bookAuthor = new BookAuthor();
            bookAuthor.setAuthor_id(author.getId());
            bookAuthor.setBook_id(book.getId());
            bookAuthorDAO.addBookAuthor(bookAuthor);
        }
    }

    @Override
    @Transactional
    public void editBookAuthor(Author author, List<Book> books) {
        deleteBookAuthor(author);
        addBookAuthor(author, books);
    }

    @Override
    @Transactional
    public void editBookAuthor(Book book, List<Author> authors) {
        deleteBookAuthor(book);
        addBookAuthor(book, authors);
    }

    @Override
    @Transactional
    public void deleteBookAuthor(Author author) {
        List<BookAuthor> bookAuthorList = getBookAuthorList(author);

        for (BookAuthor bookAuthor : bookAuthorList) {
            bookAuthorDAO.deleteBookAuthor(bookAuthor);
        }
    }

    @Override
    @Transactional
    public void deleteBookAuthor(Book book) {
        List<BookAuthor> bookAuthorList = getBookAuthorList(book);

        for (BookAuthor bookAuthor : bookAuthorList) {
            bookAuthorDAO.deleteBookAuthor(bookAuthor);
        }
    }
}
