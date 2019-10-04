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

//    @Autowired
    private AuthorService authorService;

//    @Autowired
    private BookService bookService;

//    @Autowired
    private GenreService genreService;

    @Autowired
    public void setAuthorService(AuthorService authorService) { this.authorService = authorService; };

    @Autowired
    public void setBookService(BookService bookService) { this.bookService = bookService; };

    @Autowired
    public void setGenresService(GenreService genreService) { this.genreService = genreService; };

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

    @RequestMapping(value = "/author/{id}", method = RequestMethod.GET)
    public ModelAndView author(@PathVariable("id") int id) {
        Author author = authorService.getAuthorById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("author");
        modelAndView.addObject("author", author);
        return modelAndView;
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public ModelAndView book(@PathVariable("id") int id) {
        Book book = bookService.getBookById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("book");
        modelAndView.addObject("book", book);
        return modelAndView;
    }

    @RequestMapping(value = "/genre/{id}", method = RequestMethod.GET)
    public ModelAndView genre(@PathVariable("id") int id) {
        Genre genre = genreService.getGenreById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("genre");
        modelAndView.addObject("genre", genre);
        return modelAndView;
    }

    //   Edit entity

    @RequestMapping(value = "/author/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editAuthor(@PathVariable("id") int id) {
        Author author = authorService.getAuthorById(id);
        List<Book> books = bookService.allBooks();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editAuthor");
        modelAndView.addObject("author", author);
        modelAndView.addObject("booksList", books);
        return modelAndView;
    }

    @RequestMapping(value = "/author/edit", method = RequestMethod.POST)
    public ModelAndView editAuthor(@ModelAttribute("author") Author author, @RequestParam("bookIds") int[] bookIds) {
        ModelAndView modelAndView = new ModelAndView();
        authorService.editAuthor(author, bookIds);

        modelAndView.setViewName("redirect:/author/" + author.getId());
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
    public ModelAndView editBook(@ModelAttribute("book") Book book) {
        ModelAndView modelAndView = new ModelAndView();
        int id = book.getId();
        modelAndView.setViewName("redirect:/book/" + id);
        bookService.editBook(book);
        return modelAndView;
    }

    @RequestMapping(value = "/genre/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editGenre(@PathVariable("id") int id) {
        Genre genre = genreService.getGenreById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editGenre");
        modelAndView.addObject("genre", genre);
        return modelAndView;
    }

    @RequestMapping(value = "/genre/edit", method = RequestMethod.POST)
    public ModelAndView editGenre(@ModelAttribute("genre") Genre genre) {
        ModelAndView modelAndView = new ModelAndView();
        int id = genre.getId();
        modelAndView.setViewName("redirect:/genre/" + id);
        genreService.editGenre(genre);
        return modelAndView;
    }

    //    Add entity

    @RequestMapping(value = "/author/add", method = RequestMethod.GET)
    public ModelAndView addAuthor() {
        List<Book> books = bookService.allBooks();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editAuthor");
        modelAndView.addObject("booksList", books);
        return modelAndView;
    }

    @RequestMapping(value = "/author/add", method = RequestMethod.POST)
    public ModelAndView addAuthor(@ModelAttribute("author") Author author, @RequestParam("bookIds") int[] bookIds) {
        ModelAndView modelAndView = new ModelAndView();
        Author createdAuthor = authorService.createAuthor(author, bookIds);

        modelAndView.setViewName("redirect:/author/" + createdAuthor.getId());
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
    public ModelAndView addBook(@ModelAttribute("book") Book book) {
        ModelAndView modelAndView = new ModelAndView();
        int id = bookService.addBook(book);
        modelAndView.setViewName("redirect:/book/" + id);
        return modelAndView;
    }

    @RequestMapping(value = "/genre/add", method = RequestMethod.GET)
    public ModelAndView addGenre() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editGenre");
        return modelAndView;
    }

    @RequestMapping(value = "/genre/add", method = RequestMethod.POST)
    public ModelAndView addGenre(@ModelAttribute("genre") Genre genre) {
        ModelAndView modelAndView = new ModelAndView();
        int id = genreService.addGenre(genre);
        modelAndView.setViewName("redirect:/genre/" + id);
        return modelAndView;
    }
}
