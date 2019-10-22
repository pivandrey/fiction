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
        List<Book> books = author.getBooks();
        for (Book book : books) {
            List<Author> authorsFromBook = book.getAuthors();
            authorsFromBook.add(author);
            book.setAuthors(authorsFromBook);
            bookService.editBook(book);
        }
        return createdAuthor;
    }

    @Override
    @Transactional
    public Author getAuthorById(int id) {
        return authorDAO.getAuthorById(id);
    }

    @Override
    @Transactional
    public void editAuthor(Author author) {
        List<Book> books = author.getBooks();
        System.out.print("books from author: ");
        System.out.println(books);

        for (Book book : bookService.allBooks()) {
            System.out.print("current book: ");
            System.out.println(book);

            List<Author> authorsFromBook = book.getAuthors();

            System.out.print("authorsFromBook: ");
            System.out.println(authorsFromBook);

            if (books.contains(book)) {
                if (!authorsFromBook.contains(author)) {

                    System.out.println("add author");

                    authorsFromBook.add(author);
                } else {
                    System.out.println("nothing");
                }
            } else {
                System.out.println("delete author");

                authorsFromBook.remove(author);
            }
            System.out.print("authorsFromBook after change: ");
            System.out.println(authorsFromBook);

            book.setAuthors(authorsFromBook);
            bookService.editBook(book);
        }
        authorDAO.editAuthor(author);
    }

    @Override
    @Transactional
    public void deleteAuthor(Author author) {
        bookAuthorService.deleteBookAuthor(author);
        authorDAO.deleteAuthor(author);
    }
}
