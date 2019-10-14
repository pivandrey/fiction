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
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "biography", "biography.required");

        Author author = (Author) obj;
        if (author.getFullname().length() < 2) {
            errors.rejectValue("fullname", "fullname.lessThanTwoSymbols", new Object[]{"'fullname'"}, "fullname must be more than 2 symbols");
        }
        if((author.getBirthday() + "").length() < 4) {
            errors.rejectValue("birthday", "birthday.lessThanFourDigit");
        }
    }
}
