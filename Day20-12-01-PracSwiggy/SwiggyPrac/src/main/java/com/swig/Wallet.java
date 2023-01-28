package com.swig;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wallet")
@ManagedBean
@SessionScoped
public class Wallet {
	@Id
	@Column(name = "CUS_ID")
	private int custId;
	@Column(name = "WAL_ID")
	private int walId;
	@Column(name = "WAL_AMOUNT")
	private int walAmt;
	@Enumerated(EnumType.STRING)
	@Column(name = "WAL_SOURCE")
	private WalletSource source;
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getWalId() {
		return walId;
	}
	public void setWalId(int walId) {
		this.walId = walId;
	}
	public int getWalAmt() {
		return walAmt;
	}
	public void setWalAmt(int walAmt) {
		this.walAmt = walAmt;
	}
	public WalletSource getSource() {
		return source;
	}
	public void setSource(WalletSource source) {
		this.source = source;
	}
	
	

}
