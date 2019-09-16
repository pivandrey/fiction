package library.fiction.service;

import library.fiction.model.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> allGenres();
    void addGenre(Genre genre);
    Genre getGenreById(int id);
    void editGenre(Genre genre);
}
