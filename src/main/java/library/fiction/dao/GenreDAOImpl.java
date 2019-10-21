package library.fiction.dao;

import library.fiction.model.Genre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreDAOImpl extends GenericDAOImpl implements GenreDAO {

    public GenreDAOImpl() {
        super(Genre.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Genre> allGenres() {
        return getAll("from Genre");
    }

    @Override
    public int addGenre(Genre genre) {
        save(genre);
        return genre.getId();
    }

    @Override
    public Genre getGenreById(int id) {
        return (Genre)findById(id);
    }

    @Override
    public void editGenre(Genre genre) {
        update(genre);
    }

    @Override
    public void deleteGenre(Genre genre) {
        delete(genre);
    }
}
