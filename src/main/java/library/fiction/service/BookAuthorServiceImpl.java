package library.fiction.service;

import library.fiction.dao.BookAuthorDAO;
import library.fiction.model.Author;
import library.fiction.model.Book;
import library.fiction.model.BookAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookAuthorServiceImpl implements BookAuthorService {
    private BookAuthorDAO bookAuthorDAO;


    @Autowired
    public void setAuthorDAO(BookAuthorDAO bookAuthorDAO) {
        this.bookAuthorDAO = bookAuthorDAO;
    }

    @Override
    @Transactional
    public void addBookForAuthor(Author author, List<Book> books) {
        for (Book book : books) {
            BookAuthor bookAuthor = new BookAuthor();
            bookAuthor.setAuthor_id(author.getId());
            bookAuthor.setBook_id(book.getId());
            System.out.print("Create book_author: ");
            System.out.print(author.getId() + ", ");
            System.out.println(book.getId());
            bookAuthorDAO.addBookAuthor(bookAuthor);
        }
    }
}
