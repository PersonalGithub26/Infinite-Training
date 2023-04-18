package com.java.infinite.DaoImpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("com.java.infinite.DaoImpl.PasswordValidator")
public class PasswordValidator implements Validator {
	private static final String Password_Pattern = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-])(?!.* ).{8,}$";

	private Pattern pattern;
	private Matcher matcher;

	public PasswordValidator() {
		pattern = Pattern.compile(Password_Pattern);
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		matcher = pattern.matcher(value.toString());
		if (!matcher.matches()) {

			FacesMessage msg = new FacesMessage("Password validation failed.",
					"Password must contain atleast one uppercase letter, one lowercase letter,one digit, one special character, no space, and it must be atleast 8 characters long.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}

	}

}
