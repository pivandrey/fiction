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
        if (author.getFullname().matches("\\[A-Za-z0-9]+")) {
            errors.rejectValue("fullname", "fullname.notRussian", new Object[]{"'fullname'"}, "Полное имя не должно состоять из латинских букв и цифр");
        }

        if (Integer.toString(author.getBirthday()).length() != 4) {
            errors.rejectValue("birthday", "birthday.lessThanFourDigit", new Object[]{"'birthday'"}, "Год рождения не менее 4 символов");
        }
        if (author.getBirthday() < 1500) {
            errors.rejectValue("birthday", "birthday.lessThan1500", new Object[]{"'birthday'"}, "Год рождения не менее 1500");
        }
        if (author.getBirthday() > 2019) {
            errors.rejectValue("birthday", "birthday.moreThan2019", new Object[]{"'birthday'"}, "Год рождения не более 2019");
        }

        if (author.getBiography().length() < 1) {
            errors.rejectValue("biography", "biography.isRequired", new Object[]{"'biography'"}, "Заполните биографию");
        }
        if (author.getBiography().matches("\\[A-Za-z0-9]+")) {
            errors.rejectValue("biography", "biography.notRussian", new Object[]{"'biography'"}, "Биография не должна состоять из латинских букв и цифр");
        }
    }
}
