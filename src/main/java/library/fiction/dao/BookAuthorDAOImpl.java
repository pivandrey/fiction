package library.fiction.dao;

import library.fiction.model.Author;
import library.fiction.model.Book;
import library.fiction.model.BookAuthor;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookAuthorDAOImpl extends GenericDAOImpl implements BookAuthorDAO {

    public BookAuthorDAOImpl() {
        super(BookAuthor.class);
    }

    @Override
    public List<BookAuthor> getBookAuthorList(Author author) {
        return getListById("author_id", author.getId());
    }

    @Override
    public List<BookAuthor> getBookAuthorList(Book book) {
        return getListById("book_id", book.getId());
    }

    @Override
    public void addBookAuthor(BookAuthor bookAuthor) {
        save(bookAuthor);
    }

    @Override
    public void deleteBookAuthor(BookAuthor bookAuthor) {
        delete(bookAuthor);
    }
}
