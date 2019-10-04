package library.fiction.service;

import library.fiction.dao.AuthorDAO;
import library.fiction.model.Author;
import library.fiction.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorDAO authorDAO;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookAuthorService bookAuthorService;

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
    public Author createAuthor(Author author, int[] bookIds) {
        List<Book> books = bookService.getBooksById(bookIds);
        Author createdAuthor = authorDAO.addAuthor(author);
        bookAuthorService.addBookForAuthor(createdAuthor, books);
        author.setBooks(books);
        return createdAuthor;
    }

    @Override
    @Transactional
    public Author getAuthorById(int id) {
        return authorDAO.getAuthorById(id);
    }

    @Override
    @Transactional
    public void editAuthor(Author author, int[] bookIds) {
        List<Book> books = bookService.getBooksById(bookIds);
        bookAuthorService.addBookForAuthor(author, books);
        author.setBooks(books);
        authorDAO.editAuthor(author);
    }
}
