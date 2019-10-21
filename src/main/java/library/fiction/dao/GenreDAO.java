package library.fiction.dao;

import library.fiction.model.Genre;

import java.util.List;

public interface GenreDAO extends GenericDAO {
    List<Genre> allGenres();

    int addGenre(Genre genre);

    Genre getGenreById(int id);

    void editGenre(Genre genre);

    void deleteGenre(Genre genre);
}
