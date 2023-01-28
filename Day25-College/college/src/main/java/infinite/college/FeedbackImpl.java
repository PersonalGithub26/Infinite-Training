package infinite.college;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;





@ManagedBean(name="FbDao")
@SessionScoped
public class FeedbackImpl implements FeedbackDao {

	private String instructor;
	
	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	private String subjectname;
	
	
	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	@Override
	public String AddFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void instructorLocaleCodeChanged(ValueChangeEvent e){
		String instructor = e.getNewValue().toString();
		
		this.instructor=instructor;
	}
	
	
	public List<String>showAllInstructor(){
		 SessionFactory sf = SessionHelper.getConnection();
	        Session session = sf.openSession();
	        Criteria cr = session.createCriteria(Subjects.class);
	        Projection projection=Projections.distinct(Projections.property("instructor"));
	        cr.setProjection(projection);
	        List<String> instructorlist= cr.list();
	        return instructorlist;
	}

//	public void subNameLocaleCodeChanged(ValueChangeEvent e){
//			
//		String sub = e.getNewValue().toString();
//		List rid = searchSubByInstructor(instructor);
//		
//	}

	public List<String> searchSubByInstructor(String instructor) {
		// TODO Auto-generated method stub
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Subjects.class);
		cr.add(Restrictions.eq("instructor", instructor));
		Projection projection = Projections.property("instructor");
		cr.setProjection(projection);
		List<String> subList = cr.list();
		return subList;
	}
	
	
	public String fidIdGen(){

	      SessionFactory sf = SessionHelper.getConnection();
	        Session session = sf.openSession();

	 

	        Criteria criteria = session.createCriteria(Feedback.class).setProjection(Projections.max("fid"));
	        String str = (String) criteria.uniqueResult();

	 

	        String order = str.substring(1);
	        int CoId = Integer.parseInt(order);
	        CoId++;
	        return String.format("O%03d", CoId);
		
		
	}

	
	public String addFeedback(String studentName,String instructor,String fbValue){
		Feedback fb= new Feedback();
		String fid=fidIdGen();
		fb.setFid(fid);
		fb.setStudentName(studentName);
		fb.setInstructor(instructor);
		fb.setFbValue(fbValue);
		return "Thanks2.xhtml?faces-redirect=true";
		
		
	}
	
	
}
