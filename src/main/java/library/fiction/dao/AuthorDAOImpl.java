package library.fiction.dao;

import library.fiction.model.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDAOImpl implements AuthorDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Author> allAuthors() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Author").list();
    }

    @Override
    public Author addAuthor(Author author) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(author);
        session.flush();

        return author;
    }

    @Override
    public Author getAuthorById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Author.class, id);
    }

    @Override
    public void editAuthor(Author author) {
        Session session = sessionFactory.getCurrentSession();
        session.clear();
        session.update(author);
        session.flush();
    }

    @Override
    public void deleteAuthor(Author author) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(author);
    }
}
