package infinite.Agentjsfhiber;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
@SessionScoped
public class RadioBean {
	
	private String gen;
	
	public void radioChanged(ValueChangeEvent e)
	{
		this.gen=e.getNewValue().toString();
	}

	public String getGen() {
		return gen;
	}

	public void setGen(String gen) {
		this.gen = gen;
	}
	public Gender[] getGender()
	{
		return Gender.values();
	}

}
