package com.java.project;

 

import java.util.Calendar;
import java.util.Date;

 

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

 

 

@FacesValidator("dobValidator")
public class DOBValidator implements Validator {
  @Override
  public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
    Date dob = (Date) value;

 

    if (dob == null) {
      FacesMessage msg = new FacesMessage("Date of birth validation failed.", "DOB is required.");
      msg.setSeverity(FacesMessage.SEVERITY_ERROR);
      throw new ValidatorException(msg);
    }

 

    // Create a Calendar object with today's date and clear the time
    Calendar today = Calendar.getInstance();
    today.set(Calendar.HOUR_OF_DAY, 0);
    today.set(Calendar.MINUTE, 0);
    today.set(Calendar.SECOND, 0);
    today.set(Calendar.MILLISECOND, 0);

 

    // Create a Calendar object with the DOB and clear the time
    Calendar dobCalendar = Calendar.getInstance();
    dobCalendar.setTime(dob);
    dobCalendar.set(Calendar.HOUR_OF_DAY, 0);
    dobCalendar.set(Calendar.MINUTE, 0);
    dobCalendar.set(Calendar.SECOND, 0);
    dobCalendar.set(Calendar.MILLISECOND, 0);

 

    // Check if DOB is in the future
    if (dobCalendar.after(today)) {
      FacesMessage msg = new FacesMessage("Date of birth validation failed.", "DOB cannot be in the future.");
      msg.setSeverity(FacesMessage.SEVERITY_ERROR);
      throw new ValidatorException(msg);
    }
  }
}