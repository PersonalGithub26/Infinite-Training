package com.java.Policy;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.swing.text.StyledEditorKit.BoldAction;

@ManagedBean(name = "B")
public class BooleanButton {
	
	private boolean check;

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}
	
	public void message()
	{
		String detail = check ? "Accepted" : "Rejected";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(detail));
	}

}
