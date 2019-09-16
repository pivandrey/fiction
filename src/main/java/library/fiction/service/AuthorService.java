package library.fiction.service;

import library.fiction.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> allAuthors();
    void addAuthor(Author author);
    Author getAuthorById(int id);
    void editAuthor(Author author);
}
