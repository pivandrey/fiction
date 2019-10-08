package library.fiction.dao;

import library.fiction.model.Author;
import library.fiction.model.Book;
import library.fiction.model.BookAuthor;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookAuthorDAOImpl implements BookAuthorDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<BookAuthor> getBookAuthorList(Author author) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(BookAuthor.class);
        List<BookAuthor> bookAuthorList = criteria.add(Restrictions.eq("author_id", author.getId())).list();
        return bookAuthorList;
    }

    @Override
    public List<BookAuthor> getBookAuthorList(Book book) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(BookAuthor.class);
        List<BookAuthor> bookAuthorList = criteria.add(Restrictions.eq("book_id", book.getId())).list();
        return bookAuthorList;
    }

    @Override
    public void addBookAuthor(BookAuthor bookAuthor) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(bookAuthor);
        session.flush();
    }

    @Override
    public void deleteBookAuthor(BookAuthor bookAuthor) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(bookAuthor);
        session.flush();
    }
}
