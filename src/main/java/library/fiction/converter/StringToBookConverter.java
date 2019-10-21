package library.fiction.converter;

import library.fiction.model.Book;
import library.fiction.service.BookService;
import org.springframework.core.convert.converter.Converter;

public class StringToBookConverter implements Converter<String, Book> {

    public StringToBookConverter(BookService bookService) {
        this.bookService = bookService;
    }

    private BookService bookService;

    @Override
    public Book convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }
        Book book = bookService.getBookById(Integer.parseInt(source));
        return book;
    }
}
