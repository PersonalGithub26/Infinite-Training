
public class Employ {
	
	private int empId;
	private String name;
	private String dept;
	private String desg;
	private int basic;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	public int getBasic() {
		return basic;
	}
	public void setBasic(int basic) {
		this.basic = basic;
	}
	@Override
	public String toString() {
		return "Employ [empId=" + empId + ", name=" + name + ", dept=" + dept + ", desg=" + desg + ", basic=" + basic
				+ "]";
	}
	
	
	
}
