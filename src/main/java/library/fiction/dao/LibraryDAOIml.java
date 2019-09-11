package library.fiction.dao;

import library.fiction.model.Author;
import library.fiction.model.Book;
import library.fiction.model.Genre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class LibraryDAOIml implements LibraryDAO {

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
    @SuppressWarnings("unchecked")
    public List<Book> allBooks() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Book").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Genre> allGenres() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Genre").list();
    }

    @Override
    public void addAuthor(Author author) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(author);
    }

    @Override
    public void addBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(book);
    }

    @Override
    public void addGenre(Genre genre) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(genre);
    }

    @Override
    public Author getAuthorById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Author.class, id);
    }

    @Override
    public Book getBookById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Book.class, id);
    }

    @Override
    public Genre getGenreById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Genre.class, id);
    }

    @Override
    public void editAuthor(Author author) {
        Session session = sessionFactory.getCurrentSession();
        session.update(author);
    }

    @Override
    public void editBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.update(book);
    }

    @Override
    public void editGenre(Genre genre) {
        Session session = sessionFactory.getCurrentSession();
        session.update(genre);
    }
}
