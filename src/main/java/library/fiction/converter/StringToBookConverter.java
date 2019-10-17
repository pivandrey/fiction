package library.fiction.converter;

import library.fiction.model.Book;
import library.fiction.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class StringToBookConverter implements Converter<String, Book> {

    @Autowired
    private BookService bookService;

    @Override
    public Book convert(String source) {
        System.out.print("entry to convert, source is: ");
        System.out.println(source);
        System.out.print("source is class: ");
        System.out.println(source.getClass());

        if (source == null || source.isEmpty()) {
            return null;
        }
        System.out.println("before call service");
        Book book = bookService.getBookById(Integer.parseInt(source));
//        Book book = new Book();
        System.out.println("after call service");
        return book;
    }
}
