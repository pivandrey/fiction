package library.fiction.dao;

import library.fiction.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl extends GenericDAOImpl implements BookDAO {

    public BookDAOImpl() {
        super(Book.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> allBooks() {
        return getAll("from Book");
    }

    @Override
    @SuppressWarnings("unchecked")
    public Book addBook(Book book) {
        save(book);
        return book;
    }

    @Override
    public Book getBookById(int id) {
        return (Book)findById(id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void editBook(Book book) {
        update(book);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deleteBook(Book book) {
        delete(book);
    }
}
