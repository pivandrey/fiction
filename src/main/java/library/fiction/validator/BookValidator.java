package library.fiction.validator;

import library.fiction.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class BookValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Book.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Book book = (Book) obj;
        if (book.getName().length() < 2) {
            errors.rejectValue("name", "name.lessThanTwoSymbols", new Object[]{"'name'"}, "Название должно быть не менее 2 символов");
        }
        if((book.getYear() + "").length() < 4) {
            errors.rejectValue("year", "year.lessThanFourDigit", new Object[]{"'year'"}, "Год не менее 4 символов");
        }
    }
}
