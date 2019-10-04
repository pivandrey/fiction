package library.fiction.service;

import library.fiction.model.Author;
import library.fiction.model.Book;

import java.util.List;

public interface BookAuthorService {
    void addBookForAuthor(Author author, List<Book> books);
}
