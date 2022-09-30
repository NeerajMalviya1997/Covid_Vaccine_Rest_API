package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity
public class AdharCard {
	
	@Id
	private Long adharNo;
	private String fingerPrint;
	private String eyeScan;
	
	@OneToOne
	private Pancard pancard;
	@OneToOne
	private IDCard idCard;
	public Long getAdharNo() {
		return adharNo;
	}
	public void setAdharNo(Long adharNo) {
		this.adharNo = adharNo;
	}
	public String getFingerPrint() {
		return fingerPrint;
	}
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	public String getEyeScan() {
		return eyeScan;
	}
	public void setEyeScan(String eyeScan) {
		this.eyeScan = eyeScan;
	}
	public Pancard getPancard() {
		return pancard;
	}
	public void setPancard(Pancard pancard) {
		this.pancard = pancard;
	}
	public IDCard getIdCard() {
		return idCard;
	}
	public void setIdCard(IDCard idCard) {
		this.idCard = idCard;
	}
	public AdharCard() {
		
	}
	public AdharCard(Long adharNo, String fingerPrint, String eyeScan, Pancard pancard, IDCard idCard) {
		super();
		this.adharNo = adharNo;
		this.fingerPrint = fingerPrint;
		this.eyeScan = eyeScan;
		this.pancard = pancard;
		this.idCard = idCard;
	}
	

}
