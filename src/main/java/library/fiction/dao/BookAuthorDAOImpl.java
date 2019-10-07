package library.fiction.dao;

import library.fiction.model.BookAuthor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookAuthorDAOImpl implements BookAuthorDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addBookAuthor(BookAuthor bookAuthor) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(bookAuthor);
        session.flush();
    }
}
