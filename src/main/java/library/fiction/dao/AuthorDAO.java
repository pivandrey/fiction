package library.fiction.dao;

import library.fiction.model.Author;

import java.util.List;

public interface AuthorDAO {
    List<Author> allAuthors();

    Author addAuthor(Author author);

    Author getAuthorById(int id);

    void editAuthor(Author author);

    void deleteAuthor(Author author);
}
