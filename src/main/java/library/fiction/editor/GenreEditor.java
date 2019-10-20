package library.fiction.editor;

import library.fiction.model.Author;
import library.fiction.model.Genre;
import library.fiction.service.AuthorService;
import library.fiction.service.GenreService;
import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;

public class GenreEditor extends PropertyEditorSupport {
    public GenreEditor(GenreService genreService) {
        super();
        this.genreService = genreService;
    }

    private GenreService genreService;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.isEmpty(text)) {
            setValue(null);
            return;
        }

        Genre genre = genreService.getGenreById(Integer.parseInt(text));

        if (genre == null) {
            throw new IllegalArgumentException(String.format("Genre with id [%1$s] is not supported", text));
        }

        setValue(genre);
    }

    @Override
    public String getAsText() {
        if (getValue() == null) {
            return "";
        }
        return String.valueOf(((Genre) getValue()).getId());
    }
}
