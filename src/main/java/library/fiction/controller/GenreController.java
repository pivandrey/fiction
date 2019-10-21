package library.fiction.controller;

import library.fiction.model.Genre;
import library.fiction.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GenreController {
    @Autowired
    private GenreService genreService;

    @Autowired
    @Qualifier("genreValidator")
    private Validator genreValidator;

    @RequestMapping(value = "/genre/{id}", method = RequestMethod.GET)
    public ModelAndView genre(@PathVariable("id") int id) {
        Genre genre = genreService.getGenreById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("genre");
        modelAndView.addObject("genre", genre);
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
    public ModelAndView editGenre(
            @ModelAttribute("genre") Genre genre,
            BindingResult bindingResult
    ) {
        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("editGenre");
            return modelAndView;
        }

        modelAndView.setViewName("redirect:/genre/" + genre.getId());
        genreService.editGenre(genre);
        return modelAndView;
    }

    @RequestMapping(value = "/genre/add", method = RequestMethod.GET)
    public ModelAndView addGenre() {
        Genre genre = new Genre();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("genre", genre);
        modelAndView.setViewName("addGenre");
        return modelAndView;
    }

    @RequestMapping(value = "/genre/add", method = RequestMethod.POST)
    public ModelAndView addGenre(
            @ModelAttribute("genre") Genre genre,
            BindingResult bindingResult
    ) {
        ModelAndView modelAndView = new ModelAndView();
        genreValidator.validate(genre, bindingResult);

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("editGenre");
            return modelAndView;
        }

        int id = genreService.addGenre(genre);
        modelAndView.setViewName("redirect:/genre/" + id);
        return modelAndView;
    }

    @RequestMapping(value = "/genre/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteGenre(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");

        Genre genre = genreService.getGenreById(id);
        genreService.deleteGenre(genre);
        return modelAndView;
    }
}
