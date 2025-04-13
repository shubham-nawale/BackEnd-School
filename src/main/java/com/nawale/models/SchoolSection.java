package com.nawale.models;

import java.util.List;

import com.nawale.constants.CallToActionButton;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;

@Entity
public class SchoolSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Version
    private Integer version;
    
    @Column(unique = true)
    private String sectionKey; // e.g. "hero", "courses", "facilities"
    private String title;
    private String description;
    
    @Embedded
    private CallToActionButton cta;
    
    private String heroImage;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "school_section_id")
    private List<Features> features;

    
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
	public void setSectionKey(String section) {
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
	public String getHeroImage() {
		return heroImage;
	}
	public void setHeroImage(String heroImage) {
		this.heroImage = heroImage;
	}
	public List<Features>getFeatures() {
		return features;
	}
	public void setFeatures(List<Features> features) {
		this.features = features;
	}
	
	
    
	
}
