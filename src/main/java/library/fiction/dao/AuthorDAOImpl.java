package library.fiction.dao;

import library.fiction.model.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDAOImpl extends GenericDAOImpl implements AuthorDAO {

    public AuthorDAOImpl() {
        super(Author.class);
    }

    @Override
    public List<Author> allAuthors() {
        return getAll("from Author");
    }

    @Override
    public Author addAuthor(Author author) {
        save(author);
        return author;
    }

    @Override
    public Author getAuthorById(int id) {
        return (Author)findById(id);
    }

    @Override
    public void editAuthor(Author author) {
        update(author);
    }

    @Override
    public void deleteAuthor(Author author) {
        delete(author);
    }
}
