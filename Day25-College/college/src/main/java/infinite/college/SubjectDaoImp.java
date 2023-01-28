package infinite.college;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

@ManagedBean(name="SubDao")
@SessionScoped
public class SubjectDaoImp implements SubjectDao{
	

		String[] subjects = {"PC Architecture", "PC Hardware 1", "PC Hardware 2","Microprocessor Interfacing devices & Embedded System","C#","Data Structures","Operating System","SQL Server","Networking"};  
	

		public String[] getSubjects() {
			return subjects;
		}

		public void setSubjects(String[] subjects) {
			this.subjects = subjects;
		}

		
		private int index;
		
		
		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}


		int theory[]={42,90,69,107,84,60,80,66,94};
	int practical[]={14,50,41,93,56,0,70,34,156};
	
	private String localCode;
	
	public String getLocalCode() {
		return localCode;
	}
	


	public void setLocalCode(String localCode) {
		this.localCode = localCode;
}
	
	public int gettheory(){
		
		return theory[getIndex()];
	}
	
	public int getpractical(){
		return practical[getIndex()];
	}
	

	public int subjectLocaleCodeChanged(ValueChangeEvent e){
		String rname = e.getNewValue().toString();
		int a=subjects.length;
		for(int i=0;i<=a;i++){
			if(subjects[i].equals(rname)){
				System.out.println(i+"good morning");
				setIndex(i);
				return i;
			}
		}

		
		this.localCode=rname;
		return 0;
	}
	
	@Override
	public String addSubject(int year,String instructor,String localCode,int theory,int practical)
	{
		Subjects sub= new Subjects();
		sub.setYear(year);
		sub.setInstructor(instructor);
		sub.setSubject(localCode);
		sub.setTheory(theory);
		sub.setPractical(practical);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction trans=session.beginTransaction();
        session.save(sub);
        trans.commit();
        
        return "Thanks.xhtml?faces-redirect=true";	
		
		
	}
	
	
	
	

}
