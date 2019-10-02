package library.fiction.dao;

import library.fiction.model.Genre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreDAOImpl implements GenreDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Genre> allGenres() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Genre").list();
    }

    @Override
    public int addGenre(Genre genre) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(genre);
        session.flush();

        return genre.getId();
    }

    @Override
    public Genre getGenreById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Genre.class, id);
    }

    @Override
    public void editGenre(Genre genre) {
        Session session = sessionFactory.getCurrentSession();
        session.update(genre);
    }
}
