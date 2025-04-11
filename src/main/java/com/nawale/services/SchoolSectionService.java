package com.nawale.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nawale.models.SchoolSection;
import com.nawale.repo.SchoolSectionRepository;

@Service
public class SchoolSectionService {
    @Autowired private SchoolSectionRepository repo;

    
    public void setSections(SchoolSection data) {
    	repo.save(data);
    	System.out.println("section added Successfully");
    }
    public List<SchoolSection> getAllSections() {
        return repo.findAll();
    }

    public Optional<SchoolSection> getSectionByKey(String sectionKey) {
        return repo.findBySectionKey(sectionKey);
    }
    
    public ResponseEntity<String> deleteSectionByKey(String key) {

        Optional<SchoolSection> sectionOpt = repo.findBySectionKey(key);

    	if (sectionOpt.isPresent()) {
    		repo.deleteBySectionKey(key);
            return ResponseEntity.ok("Section with key '" + key + "' deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("Section with key '" + key + "' not found.");
        }
    }
    
    public SchoolSection updateSection(String sectionKey, SchoolSection updatedData) {
        return repo.findBySectionKey(sectionKey)  // This returns Optional<SchoolSection>
                .map(existing -> {
                    existing.setTitle(updatedData.getTitle());
                    existing.setDescription(updatedData.getDescription());
                    return repo.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Section not found"));
    }
    
    

}
