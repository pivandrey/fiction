package library.fiction.editor;

import library.fiction.model.Book;
import library.fiction.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;

public class BookEditor extends PropertyEditorSupport {

    @Autowired
    BookService bookService;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.print("entry to setAsText, text is: ");
        System.out.println(text);
        if (StringUtils.isEmpty(text)) {
            setValue(null);
            return;
        }

        Book book = bookService.getBookById(Integer.valueOf(text));
        System.out.print("setAsText, book is: ");
        System.out.println(book);
        if (book == null) {
            System.out.println("book is null");
            throw new IllegalArgumentException(String.format("Book with id [%1$s] is not supported", text));
        }
        System.out.println("now book will be set");
        setValue(book);
    }

    @Override
    public String getAsText() {
        System.out.println("entry to getAsText");
        if (getValue() == null) {
            return "";
        }
        return String.valueOf(((Book) getValue()).getId());
    }
}
