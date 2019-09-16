package library.fiction.service;

import library.fiction.dao.GenreDAO;
import library.fiction.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    private GenreDAO genreDAO;

    @Autowired
    public void setGenreDAO(GenreDAO genreDAO) { this.genreDAO = genreDAO; };

    @Override
    @Transactional
    public List<Genre> allGenres() {
        return genreDAO.allGenres();
    }

    @Override
    @Transactional
    public void addGenre(Genre genre) {
        genreDAO.addGenre(genre);
    }

    @Override
    @Transactional
    public Genre getGenreById(int id) {
        return genreDAO.getGenreById(id);
    }

    @Override
    @Transactional
    public void editGenre(Genre genre) {
        genreDAO.editGenre(genre);
    }
}
