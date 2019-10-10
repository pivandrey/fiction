package library.fiction.dao;

import library.fiction.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> allBooks() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Book").list();
    }

    @Override
    public Book addBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(book);
        session.flush();

        return book;
    }

    @Override
    public Book getBookById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Book.class, id);
    }

    @Override
    public void editBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.clear();
        session.update(book);
        session.flush();
    }

    @Override
    public void deleteBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(book);
    }
}
