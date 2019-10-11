package library.fiction.dao;

import library.fiction.model.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookGenreDAOImpl extends GenericDAOImpl implements BookGenreDAO {

    public BookGenreDAOImpl() {
        super(BookGenre.class);
    }

    @Override
    public List<BookGenre> getBookGenreList(Genre genre) {
        return getListById("genre_id", genre.getId());
    }

    @Override
    public List<BookGenre> getBookGenreList(Book book) {
        return getListById("book_id", book.getId());
    }

    @Override
    public void addBookGenre(BookGenre bookGenre) {
        save(bookGenre);
    }

    @Override
    public void deleteBookGenre(BookGenre bookGenre) {
        delete(bookGenre);
    }
}
