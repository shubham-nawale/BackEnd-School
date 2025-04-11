package com.nawale.models;

import com.nawale.constants.CallToActionButton;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SchoolSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String sectionKey; // e.g. "hero", "courses", "facilities"
    private String title;
    private String description;
    
    @Embedded
    private CallToActionButton cta;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id, CallToActionButton cta) {
		this.id = id;
		this.cta = cta;
	}
	public String getSectionByKey() {
		return sectionKey;
	}
	public void setSection(String section) {
		this.sectionKey = section;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public CallToActionButton getCta() {
		return cta;
	}
	public void setCta(CallToActionButton cta) {
		this.cta = cta;
	}
    
}
