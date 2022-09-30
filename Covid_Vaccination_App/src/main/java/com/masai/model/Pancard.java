package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pancard {
	
  @Id
  private String panNo;
  @OneToOne
  private IDCard idCard;
  @OneToOne
  private AdharCard adharcard;
public String getPanNo() {
	return panNo;
}
public void setPanNo(String panNo) {
	this.panNo = panNo;
}
public IDCard getIdCard() {
	return idCard;
}
public void setIdCard(IDCard idCard) {
	this.idCard = idCard;
}
public AdharCard getAdharcard() {
	return adharcard;
}
public void setAdharcard(AdharCard adharcard) {
	this.adharcard = adharcard;
}
public Pancard(String panNo, IDCard idCard, AdharCard adharcard) {
	super();
	this.panNo = panNo;
	this.idCard = idCard;
	this.adharcard = adharcard;
}
public Pancard() {
	
}
	

}
