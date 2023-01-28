package com.hib.complaint;


import java.sql.Timestamp;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "complaint")
@ManagedBean
@SessionScoped
public class Complaint {

	@Id
	@GenericGenerator(name = "custom_generator", strategy = "com.hib.complaint.CompIdGenerator")
	@GeneratedValue(generator = "custom_generator")
	@Column(name = "ComplaintID")
	private String complaintID;

	@Column(name = "ComplaintType")
	private String complaintType;

	@Column(name = "CDescription")
	private String cDescription;

	@Column(name = "ComplaintDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date complaintDate;

	@Column(name = "Severity")
	private String severity;

	@Column(name = "Status")
	private String status;
	
	@OneToOne(targetEntity = ResolveE.class, cascade = CascadeType.ALL)
	private ResolveE resolveE;
	
	
	

	public ResolveE getResolveE() {
		return resolveE;
	}

	public void setResolveE(ResolveE resolveE) {
		this.resolveE = resolveE;
	}

	public String getComplaintID() {
		return complaintID;
	}

	public void setComplaintID(String complaintID) {
		this.complaintID = complaintID;
	}

	

	public String getComplaintType() {
		return complaintType;
	}

	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}

	public String getcDescription() {
		return cDescription;
	}

	public void setcDescription(String cDescription) {
		this.cDescription = cDescription;
	}

	public Date getComplaintDate() {
		return complaintDate;
	}

	public void setComplaintDate(Date complaintDate) {
		this.complaintDate = complaintDate;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Complaint [complaintID=" + complaintID + ", complaintType=" + complaintType + ", cDescription="
				+ cDescription + ", complaintDate=" + complaintDate + ", severity=" + severity + ", status=" + status
				+ "]";
	}
	
	

}


	


