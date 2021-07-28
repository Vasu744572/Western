package com.tour.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
@Entity
public class Facility {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private boolean isflight;
	private boolean ismeal;
	private boolean iscab;
	private boolean ishotel;
	@Lob
	private  String smallDescripton;
	@Lob
	private String detailedDescription;
	@ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.DETACH)
	@JoinTable(name= "facilities_categories")
	private Set<Category> categories;
	
	public boolean isIsflight() {
		
		return isflight;
	}
	public void setIsflight(boolean isflight) {
		this.isflight = isflight;
	}
	public boolean isIsmeal() {
		return ismeal;
	}
	public void setIsmeal(boolean ismeal) {
		this.ismeal = ismeal;
	}
	public boolean isIscab() {
		return iscab;
	}
	public void setIscab(boolean iscab) {
		this.iscab = iscab;
	}
	public boolean isIshotel() {
		return ishotel;
	}
	public void setIshotel(boolean ishotel) {
		this.ishotel = ishotel;
	}
	public String getSmallDescripton() {
		return smallDescripton;
	}
	public void setSmallDescripton(String smallDescripton) {
		this.smallDescripton = smallDescripton;
	}
	public String getDetailedDescription() {
		return detailedDescription;
	}
	public void setDetailedDescription(String detailedDescription) {
		this.detailedDescription = detailedDescription;
	}
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	} 
	
	
}
