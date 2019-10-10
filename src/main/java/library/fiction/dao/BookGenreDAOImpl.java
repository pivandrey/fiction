package library.fiction.dao;

import library.fiction.model.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookGenreDAOImpl implements BookGenreDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<BookGenre> getBookGenreList(Genre genre) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(BookGenre.class);
        List<BookGenre> bookGenreList = criteria.add(Restrictions.eq("genre_id", genre.getId())).list();
        return bookGenreList;
    }

    @Override
    public List<BookGenre> getBookGenreList(Book book) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(BookGenre.class);
        List<BookGenre> bookGenreList = criteria.add(Restrictions.eq("book_id", book.getId())).list();
        return bookGenreList;
    }

    @Override
    public void addBookGenre(BookGenre bookGenre) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(bookGenre);
        session.flush();
    }

    @Override
    public void deleteBookGenre(BookGenre bookGenre) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(bookGenre);
        session.flush();
    }
}
