package com.tour.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import com.tour.entity.Tourpackage;

public class AssetPojo {
	private long id;
	private String imagename;
	private String filetype;
	private String filesize;
	@Lob
    private byte[] image;
	@Lob
	private String base64;

	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<Tourpackage> tourpackage;
	
	
	public Set<Tourpackage> getTourpackage() {
		return tourpackage;
	}
	public void setTourpackage(Set<Tourpackage> tourpackage) {
		this.tourpackage = tourpackage;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public String getFilesize() {
		return filesize;
	}
	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getBase64() {
		return base64;
	}
	public void setBase64(String base64) {
		this.base64 = base64;
	}
}
