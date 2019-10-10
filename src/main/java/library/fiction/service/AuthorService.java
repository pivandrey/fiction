package library.fiction.service;

import library.fiction.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> allAuthors();

    List<Author> getAuthorsById(int[] authorIds);

    Author createAuthor(Author author, int[] bookIds);

    Author getAuthorById(int id);

    void editAuthor(Author author, int[] bookIds);

    void deleteAuthor(Author author);
}
