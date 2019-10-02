package library.fiction.service;

import library.fiction.dao.AuthorDAO;
import library.fiction.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorDAO authorDAO;

    @Autowired
    public void setAuthorDAO(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    @Override
    @Transactional
    public List<Author> allAuthors() {
        return authorDAO.allAuthors();
    }


    @Override
    @Transactional
    public int addAuthor(Author author) {
        return authorDAO.addAuthor(author);
    }

    @Override
    @Transactional
    public Author getAuthorById(int id) {
        return authorDAO.getAuthorById(id);
    }

    @Override
    @Transactional
    public void editAuthor(Author author) {
        authorDAO.editAuthor(author);
    }
}
