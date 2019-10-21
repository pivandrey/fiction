package library.fiction.service;

import library.fiction.dao.GenreDAO;
import library.fiction.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    private GenreDAO genreDAO;

    @Autowired
    private BookGenreService bookGenreService;

    @Autowired
    public void setGenreDAO(GenreDAO genreDAO) { this.genreDAO = genreDAO; };

    @Override
    @Transactional
    public List<Genre> allGenres() {
        return genreDAO.allGenres();
    }

    @Override
    @Transactional
    public int addGenre(Genre genre) {
        return genreDAO.addGenre(genre);
    }

    @Override
    @Transactional
    public Genre getGenreById(int id) {
        return genreDAO.getGenreById(id);
    }

    @Override
    @Transactional
    public List<Genre> getGenresById(int[] genresIds) {
        List<Genre> genres = new ArrayList<>();
        for (int id : genresIds) {
            Genre genre = genreDAO.getGenreById(id);
            genres.add(genre);
        }
        return genres;
    }

    @Override
    @Transactional
    public void editGenre(Genre genre) {
        genreDAO.editGenre(genre);
    }

    @Override
    @Transactional
    public void deleteGenre(Genre genre) {
        bookGenreService.deleteBookGenre(genre);
        genreDAO.deleteGenre(genre);
    }
}
