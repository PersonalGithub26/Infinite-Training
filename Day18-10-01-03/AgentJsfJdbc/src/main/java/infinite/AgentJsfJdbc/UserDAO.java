package infinite.AgentJsfJdbc;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
@ManagedBean
@SessionScoped
public class UserDAO {
	
	public String validate(User user)
	{
		if(user.getUserName().equals("chandu") && user.getPassword().equals("chandu"))
		{
			return "AgentShow.xhtml?faces-redirect=true";
		}
		else {
			Map<String,Object> sessionMap=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			sessionMap.put("errorMessage", "Invalid Credintials");
			return "Login.xhtml?faces-redirect=true";
		}
	}

}
