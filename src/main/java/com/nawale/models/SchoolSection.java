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
import lombok.Data;
import lombok.Getter;

@Data
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
    
    @Getter
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "school_section_id")
    private List<Features> features;

}
