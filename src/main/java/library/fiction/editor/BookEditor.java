package library.fiction.editor;

import library.fiction.model.Book;
import library.fiction.service.BookService;
import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;

public class BookEditor extends PropertyEditorSupport {
    public BookEditor(BookService bookService) {
        super();
        this.bookService = bookService;
    }

    private BookService bookService;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.isEmpty(text)) {
            setValue(null);
            return;
        }

        Book book = bookService.getBookById(Integer.parseInt(text));

        if (book == null) {
            throw new IllegalArgumentException(String.format("Book with id [%1$s] is not supported", text));
        }

        setValue(book);
    }

    @Override
    public String getAsText() {
        if (getValue() == null) {
            return "";
        }
        return String.valueOf(((Book) getValue()).getId());
    }
}
