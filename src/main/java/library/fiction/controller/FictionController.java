package library.fiction.controller;

import library.fiction.model.Author;
import library.fiction.model.Book;
import library.fiction.model.Genre;
import library.fiction.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FictionController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Autowired
    private GenreService genreService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView library() {
        List<Author> authors = authorService.allAuthors();
        List<Book> books = bookService.allBooks();
        List<Genre> genres = genreService.allGenres();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("library");
        modelAndView.addObject("authorsList", authors);
        modelAndView.addObject("booksList", books);
        modelAndView.addObject("genresList", genres);
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
