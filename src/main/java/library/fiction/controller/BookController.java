package library.fiction.controller;

import library.fiction.model.Author;
import library.fiction.model.Book;
import library.fiction.model.Genre;
import library.fiction.service.AuthorService;
import library.fiction.service.BookService;
import library.fiction.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Autowired
    private GenreService genreService;

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public ModelAndView book(@PathVariable("id") int id) {
        Book book = bookService.getBookById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("book");
        modelAndView.addObject("book", book);
        return modelAndView;
    }

    @RequestMapping(value = "/book/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editBook(@PathVariable("id") int id) {
        Book book = bookService.getBookById(id);
        List<Author> authors = authorService.allAuthors();
        List<Genre> genres = genreService.allGenres();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editBook");
        modelAndView.addObject("book", book);
        modelAndView.addObject("authorsList", authors);
        modelAndView.addObject("genresList", genres);
        return modelAndView;
    }

    @RequestMapping(value = "/book/edit", method = RequestMethod.POST)
    public ModelAndView editBook(@ModelAttribute("book") Book book,
                                 @RequestParam("authorIds") int[] authorIds,
                                 @RequestParam("genreIds") int[] genreIds) {
        ModelAndView modelAndView = new ModelAndView();
        bookService.editBook(book, authorIds, genreIds);

        modelAndView.setViewName("redirect:/book/" + book.getId());
        return modelAndView;
    }

    @RequestMapping(value = "/book/add", method = RequestMethod.GET)
    public ModelAndView addBook() {
        List<Author> authors = authorService.allAuthors();
        List<Genre> genres = genreService.allGenres();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editBook");
        modelAndView.addObject("authorsList", authors);
        modelAndView.addObject("genresList", genres);
        return modelAndView;
    }

    @RequestMapping(value = "/book/add", method = RequestMethod.POST)
    public ModelAndView addBook(@ModelAttribute("book") Book book,
                                @RequestParam("authorIds") int[] authorIds,
                                @RequestParam("genreIds") int[] genreIds) {
        ModelAndView modelAndView = new ModelAndView();
        Book createdBook = bookService.createBook(book, authorIds, genreIds);

        modelAndView.setViewName("redirect:/book/" + createdBook.getId());
        return modelAndView;
    }

    @RequestMapping(value = "/book/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteBook(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");

        Book book = bookService.getBookById(id);
        bookService.deleteBook(book);
        return modelAndView;
    }
}
