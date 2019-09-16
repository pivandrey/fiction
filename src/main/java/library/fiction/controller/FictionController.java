package library.fiction.controller;

import library.fiction.model.Author;
import library.fiction.model.Book;
import library.fiction.model.Genre;
import library.fiction.service.LibraryService;
import library.fiction.service.LibraryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FictionController {

    private LibraryService libraryService;

    @Autowired
    public void setLibraryService(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView library() {
        List<Author> authors = libraryService.allAuthors();
        List<Book> books = libraryService.allBooks();
        List<Genre> genres = libraryService.allGenres();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("library");
        modelAndView.addObject("authorsList", authors);
        modelAndView.addObject("booksList", books);
        modelAndView.addObject("genresList", genres);
        return modelAndView;
    }

    @RequestMapping(value = "/author/{id}", method = RequestMethod.GET)
    public ModelAndView author(@PathVariable("id") int id) {
        Author author = libraryService.getAuthorById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("author");
        modelAndView.addObject("author", author);
        return modelAndView;
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public ModelAndView book(@PathVariable("id") int id) {
        Book book = libraryService.getBookById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("book");
        modelAndView.addObject("book", book);
        return modelAndView;
    }

    @RequestMapping(value = "/genre/{id}", method = RequestMethod.GET)
    public ModelAndView genre(@PathVariable("id") int id) {
        Genre genre = libraryService.getGenreById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("genre");
        modelAndView.addObject("genre", genre);
        return modelAndView;
    }

    //   Edit entity

    @RequestMapping(value = "/author/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editAuthor(@PathVariable("id") int id) {
        Author author = libraryService.getAuthorById(id);
        List<Book> books = libraryService.allBooks();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editAuthor");
        modelAndView.addObject("author", author);
        modelAndView.addObject("booksList", books);
        return modelAndView;
    }

    @RequestMapping(value = "/author/edit", method = RequestMethod.POST)
    public ModelAndView editAuthor(@ModelAttribute("author") Author author) {
        ModelAndView modelAndView = new ModelAndView();
        int id = author.getId();
        modelAndView.setViewName("redirect:/author/" + id);
        libraryService.editAuthor(author);
        return modelAndView;
    }

    @RequestMapping(value = "/book/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editBook(@PathVariable("id") int id) {
        Book book = libraryService.getBookById(id);
        List<Author> authors = libraryService.allAuthors();
        List<Genre> genres = libraryService.allGenres();
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
        libraryService.editBook(book);
        return modelAndView;
    }

    @RequestMapping(value = "/genre/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editGenre(@PathVariable("id") int id) {
        Genre genre = libraryService.getGenreById(id);
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
        libraryService.editGenre(genre);
        return modelAndView;
    }

    //    Add entity

    @RequestMapping(value = "/author/add", method = RequestMethod.GET)
    public ModelAndView addAuthor() {
        List<Book> books = libraryService.allBooks();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editAuthor");
        modelAndView.addObject("booksList", books);
        return modelAndView;
    }

    @RequestMapping(value = "/author/add", method = RequestMethod.POST)
    public ModelAndView addAuthor(@ModelAttribute("author") Author author) {
        ModelAndView modelAndView = new ModelAndView();
        int id = author.getId();
        modelAndView.setViewName("redirect:/author/" + id);
        libraryService.addAuthor(author);
        return modelAndView;
    }

    @RequestMapping(value = "/book/add", method = RequestMethod.GET)
    public ModelAndView addBook() {
        List<Author> authors = libraryService.allAuthors();
        List<Genre> genres = libraryService.allGenres();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editBook");
        modelAndView.addObject("authorsList", authors);
        modelAndView.addObject("genresList", genres);
        return modelAndView;
    }

    @RequestMapping(value = "/book/add", method = RequestMethod.POST)
    public ModelAndView addBook(@ModelAttribute("book") Book book) {
        ModelAndView modelAndView = new ModelAndView();
        int id = book.getId();
        modelAndView.setViewName("redirect:/book/" + id);
        libraryService.addBook(book);
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
        int id = genre.getId();
        modelAndView.setViewName("redirect:/genre/" + id);
        libraryService.addGenre(genre);
        return modelAndView;
    }
}
