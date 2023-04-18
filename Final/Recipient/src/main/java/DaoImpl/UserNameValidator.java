package com.java.infinite.DaoImpl;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.java.infinite.Recipient.SignUpRecipient;

@FacesValidator("com.java.infinite.DaoImpl.UserNameValidator")
public class UserNameValidator implements Validator {
	
	

	public UserNameValidator() {
		
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
//		String error = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("dberror");
//		if (error != "null") {
//			System.out.println("Db Error from Program " + error);
//			// String detail = new String(error);
//			FacesMessage msg = new FacesMessage("Db Error", error);
//			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
//			throw new ValidatorException(msg);
//		}

		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		String user = value.toString();
		Query query = session.createQuery("from Login Where userName='" + user + "'");
		java.util.List<SignUpRecipient> list = query.list();
		int count = list.size();
		if (count==1) {

			FacesMessage msg = 
				new FacesMessage("UserName Validation...", 
						"UserName Already Exists! Try Another One");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}

}
