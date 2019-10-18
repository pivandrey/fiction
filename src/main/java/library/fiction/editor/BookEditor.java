package library.fiction.editor;

import library.fiction.model.Book;
import library.fiction.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;

public class BookEditor extends PropertyEditorSupport {
    public BookEditor(BookService bookService) {
        super();
        this.bookService = bookService;
    }

    private BookService bookService;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.print("entry to setAsText, text is: ");
        System.out.println(text);
        System.out.print("Text is class: ");
        System.out.println(text.getClass());

//        List<Book> books = new ArrayList<>();
//        String[] data = text.split(",");
        if (StringUtils.isEmpty(text)) {
            System.out.println("string utils is empty");
            setValue(null);
            return;
        }

        System.out.println("before call service");
        Book book = bookService.getBookById(Integer.parseInt(text));
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
