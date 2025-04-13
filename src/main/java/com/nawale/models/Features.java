package com.nawale.models;

import jakarta.persistence.*;

@Entity
public class Features {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String featureTitle;
    private String featureDescription;
    private String icon;

    // Getters and setters
    public String getFeatureTitle() {
        return featureTitle;
    }

    public void setFeatureTitle(String featureTitle) {
        this.featureTitle = featureTitle;
    }

    public String getFeatureDescription() {
        return featureDescription;
    }

    public void setFeatureDescription(String featureDescription) {
        this.featureDescription = featureDescription;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
