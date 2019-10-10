package library.fiction.controller;

import library.fiction.model.Genre;
import library.fiction.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GenreController {
    @Autowired
    private GenreService genreService;

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
    public ModelAndView editGenre(@ModelAttribute("genre") Genre genre) {
        ModelAndView modelAndView = new ModelAndView();
        int id = genre.getId();
        modelAndView.setViewName("redirect:/genre/" + id);
        genreService.editGenre(genre);
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
