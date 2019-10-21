package library.fiction.validator;

import library.fiction.model.Genre;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class GenreValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Genre.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Genre genre = (Genre) obj;
        if (genre.getName().length() < 2) {
            errors.rejectValue("name", "name.lessThanTwoSymbols", new Object[]{"'name'"}, "Название должно быть не менее 2 символов");
        }
        if (genre.getName().contains("\\[A-Za-z0-9]+")) {
            errors.rejectValue("name", "name.notRussian", new Object[]{"'name'"}, "Название не должно состоять из латинских букв и цифр");
        }
    }
}
