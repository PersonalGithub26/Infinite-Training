package com.jsf.complant;

import java.sql.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@ManagedBean
@SessionScoped
@Entity
@Table(name = "Complaint")
public class ComplaintE {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ComplaintID", unique = true, nullable = false)
   private int complaintID;
   
   @Column(name = "ComplaintNumber", unique = true, nullable = false)
   private String complaintNumber;
   
   @Column(name = "ComplaintType")
   private String complaintType;
   
   @Column(name = "CDescription")
   private String cDescription;
   
   @Column(name = "ComplaintDate", insertable = false, updatable = false)
   @Temporal(TemporalType.TIMESTAMP)
   private Date complaintDate;
   
   @Column(name = "Severity")
   private String severity;
   
   @Column(name = "Status")
   private String status;
   
   @PrePersist
   public void setComplaintNumber() {
      this.complaintNumber = "C" + String.format("%03d", complaintID);
   }
   
}