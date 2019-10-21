package library.fiction.editor;

import library.fiction.model.Author;
import library.fiction.service.AuthorService;
import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;

public class AuthorEditor extends PropertyEditorSupport {
    public AuthorEditor(AuthorService authorService) {
        super();
        this.authorService = authorService;
    }

    private AuthorService authorService;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.isEmpty(text)) {
            setValue(null);
            return;
        }

        Author author = authorService.getAuthorById(Integer.parseInt(text));

        if (author == null) {
            throw new IllegalArgumentException(String.format("Author with id [%1$s] is not supported", text));
        }

        setValue(author);
    }

    @Override
    public String getAsText() {
        if (getValue() == null) {
            return "";
        }
        return String.valueOf(((Author) getValue()).getId());
    }
}
