package library.fiction.dao;

import library.fiction.model.Genre;

import java.util.List;

public interface GenreDAO {
    List<Genre> allGenres();
    int addGenre(Genre genre);
    Genre getGenreById(int id);
    void editGenre(Genre genre);
}