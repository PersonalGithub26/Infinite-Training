package infinite.Agentjsfhiber;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

@ManagedBean(name = "aDao")
@SessionScoped
public class AgentDaoImp implements AgentDAO{
	SessionFactory sf;
	Session session;
	Query query;
	@Override
	public List<Agent> showAgent() {
		sf=SessionHelper.getConnection();
		session=sf.openSession();
		Criteria cr = session.createCriteria(Agent.class);
		cr.addOrder(Order.asc("premium"));
		List<Agent> AgentList = cr.list();
		return AgentList;
	}
	
	public List<Agent> getAgentByGender(Gender gender) {
        SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Criteria cr = session.createCriteria(Agent.class);
        cr.add(Restrictions.eq("gender", gender));
        List<Agent> employList = cr.list();
        return employList;
    }
	 public List<String> getAllGenders() {
	        SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
	        Session session = sf.openSession();
	        Criteria cr = session.createCriteria(Agent.class);
	        cr.setProjection(Projections.distinct(Projections.property("gender")));
	        List<String> deptNames = cr.list();
	        return deptNames;
	    }
	 private String localCode;
	 
	
	public String getLocalCode() {
		return localCode;
	}

	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}

	public void AgentLocalCodeChanger(ValueChangeEvent e)
	{
		this.localCode=e.getNewValue().toString();
	}

	

}
