package library.fiction.controller;

import library.fiction.editor.BookEditor;
import library.fiction.model.Author;
import library.fiction.model.Book;
import library.fiction.service.AuthorService;
import library.fiction.service.BookService;
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
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @InitBinder
    protected void setupConverter(final HttpServletRequest request, final ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Book.class, new BookEditor());
    }

    @Autowired
    @Qualifier("authorValidator")
    private Validator authorValidator;

    @RequestMapping(value = "/author/{id}", method = RequestMethod.GET)
    public ModelAndView author(@PathVariable("id") int id) {
        Author author = authorService.getAuthorById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("author");
        modelAndView.addObject("author", author);
        return modelAndView;
    }

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

    @RequestMapping(value = "/author/add", method = RequestMethod.GET)
    public ModelAndView addAuthor() {
        List<Book> books = bookService.allBooks();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addAuthor");

        /** Для form:form необходимо добавлять пустой объект в модель */
        modelAndView.addObject("author", new Author());
        modelAndView.addObject("booksList", books);
        return modelAndView;
    }

    @RequestMapping(value = "/author/add", method = RequestMethod.POST)
    public ModelAndView addAuthor(
            @Valid @ModelAttribute("author") Author author,
            @RequestParam(value = "bookIds", required = false) int[] bookIds,
            BindingResult bindingResult
    ) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("entry to controller");
        authorValidator.validate(author, bindingResult);

        if (bindingResult.hasErrors()) {
            System.out.println("Has errors");
            modelAndView.setViewName("addAuthor");

            System.out.print("Binding result: ");
            System.out.println(bindingResult);

            return modelAndView;
        }

        Author createdAuthor = authorService.createAuthor(author, bookIds);
        modelAndView.setViewName("redirect:/author/" + createdAuthor.getId());
        return modelAndView;
    }

    @RequestMapping(value = "/author/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteAuthor(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");

        Author author = authorService.getAuthorById(id);
        authorService.deleteAuthor(author);
        return modelAndView;
    }
}
