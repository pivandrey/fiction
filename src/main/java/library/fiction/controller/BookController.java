package library.fiction.controller;

import library.fiction.editor.AuthorEditor;
import library.fiction.editor.GenreEditor;
import library.fiction.model.Author;
import library.fiction.model.Book;
import library.fiction.model.Genre;
import library.fiction.service.AuthorService;
import library.fiction.service.BookService;
import library.fiction.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Autowired
    private GenreService genreService;


    @InitBinder
    protected void setupConverter(final HttpServletRequest request, final ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Author.class, new AuthorEditor(authorService));
        binder.registerCustomEditor(Genre.class, new GenreEditor(genreService));
    }

    @Autowired
    @Qualifier("bookValidator")
    private Validator bookValidator;

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
    public ModelAndView editBook(
            @Valid @ModelAttribute("book") Book book,
            BindingResult bindingResult
    ) {
        ModelAndView modelAndView = new ModelAndView();
        bookValidator.validate(book, bindingResult);

        if (bindingResult.hasErrors()) {
            List<Author> authors = authorService.allAuthors();
            List<Genre> genres = genreService.allGenres();
            modelAndView.setViewName("editBook");
            modelAndView.addObject("authorsList", authors);
            modelAndView.addObject("genresList", genres);
            return modelAndView;
        }

        bookService.editBook(book);

        modelAndView.setViewName("redirect:/book/" + book.getId());
        return modelAndView;
    }

    @RequestMapping(value = "/book/add", method = RequestMethod.GET)
    public ModelAndView addBook() {
        List<Author> authors = authorService.allAuthors();
        List<Genre> genres = genreService.allGenres();
        Book book = new Book();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addBook");
        modelAndView.addObject("book", book);
        modelAndView.addObject("authorsList", authors);
        modelAndView.addObject("genresList", genres);
        return modelAndView;
    }

    @RequestMapping(value = "/book/add", method = RequestMethod.POST)
    public ModelAndView addBook(
            @Valid @ModelAttribute("book") Book book,
            BindingResult bindingResult
    ) {
        ModelAndView modelAndView = new ModelAndView();
        bookValidator.validate(book, bindingResult);


        if (bindingResult.hasErrors()) {
            List<Author> authors = authorService.allAuthors();
            List<Genre> genres = genreService.allGenres();
            modelAndView.setViewName("addBook");
            modelAndView.addObject("authorsList", authors);
            modelAndView.addObject("genresList", genres);
            return modelAndView;
        }

        List<Author> authors = book.getAuthors();

        Book createdBook = bookService.createBook(book);
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
