package library.fiction.service;

import library.fiction.dao.AuthorDAO;
import library.fiction.model.Author;
import library.fiction.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public List<Author> getAuthorsById(int[] authorIds) {
        List<Author> authors = new ArrayList<>();
        for (int id : authorIds) {
            Author author = authorDAO.getAuthorById(id);
            authors.add(author);
        }
        return authors;
    }

    @Override
    @Transactional
    public Author createAuthor(Author author) {
        Author createdAuthor = authorDAO.addAuthor(author);
        List<Book> books = createdAuthor.getBooks();
        bookAuthorService.addBookAuthor(createdAuthor, books);
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
        bookAuthorService.editBookAuthor(author, books);
        author.setBooks(books);
        authorDAO.editAuthor(author);
    }

    @Override
    @Transactional
    public void deleteAuthor(Author author) {
        bookAuthorService.deleteBookAuthor(author);
        authorDAO.deleteAuthor(author);
    }
}
