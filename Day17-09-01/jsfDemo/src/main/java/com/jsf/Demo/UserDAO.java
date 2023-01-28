package com.jsf.Demo;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class UserDAO {
	
	public String validate(User user)
	{
		if(user.getUserName().equals("infinite") && user.getPassWord().equals("chandu"))
		{
			return "EmployShow.xhtml?faces-redirect=true";
		}
		else
		{
			Map<String,Object> sessionMap=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			sessionMap.put("errorMessage", "Invalid Credintials");
			//FacesContext.getCurrentInstance().addMessage("loginForm:messages", new FacesMessage("Invalid user name or password. Please try again."));
		  
			return "UserInput.xhtml?faces-redirect=true";
			//return "login Failed";

		}
	}

}
