package com.nawale.constants;

import jakarta.persistence.Embeddable;

@Embeddable
public class CallToActionButton {
	public String label;
	public String link;
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	
}
