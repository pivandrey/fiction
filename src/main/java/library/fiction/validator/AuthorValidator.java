package library.fiction.validator;

import library.fiction.model.Author;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Service
public class AuthorValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Author.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Author author = (Author) obj;
        if (author.getFullname().length() < 2) {
            errors.rejectValue("fullname", "fullname.lessThanTwoSymbols", new Object[]{"'fullname'"}, "Полное имя должно быть не менее 2 символов");
        }
        if((author.getBirthday() + "").length() < 4) {
            errors.rejectValue("birthday", "birthday.lessThanFourDigit", new Object[]{"'birthday'"}, "Год рождения не менее 4 символов");
        }
        if (author.getBiography().length() < 1) {
            errors.rejectValue("biography", "biography.isRequired", new Object[]{"'biography'"}, "Заполните биографию");
        }
    }
}
