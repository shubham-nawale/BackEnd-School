package com.nawale.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nawale.models.SchoolSection;
import com.nawale.services.SchoolSectionService;

@RestController
@RequestMapping("/api/school/sections")
@CrossOrigin(origins = "*") // Allow frontend access
public class SchoolSectionController {

    private SchoolSectionService service;
    

    public SchoolSectionController(SchoolSectionService service) {
        this.service = service;
    }
    
    @PostMapping("/set")
    public void setSection(@RequestBody SchoolSection sectionData) {
    	service.setSections(sectionData);
    }
    @GetMapping("/getAll")
    public List<SchoolSection> getAllSections() {
        return service.getAllSections();
    }

    @GetMapping("/{sectionKey}")
    public SchoolSection getSection(@PathVariable String sectionKey) {
        return service.getSectionByKey(sectionKey)
                .orElseThrow(() -> new RuntimeException("Section not found"));
    }
    
    @DeleteMapping("/delete/key/{sectionKey}")
    public void deleteSectionByKey(@PathVariable String sectionKey)
    {
    	service.deleteSectionByKey(sectionKey);
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteSectionById(@RequestParam long id)
    {
    	 return service.deleteSectionById(id);
    }

    @PutMapping("/{sectionKey}")
    public SchoolSection updateSection(@PathVariable String sectionKey, @RequestBody SchoolSection updatedSection) {
        return service.updateSection(sectionKey, updatedSection);
    }
    
    // Fetch homepage section
    @GetMapping("/home")
    public ResponseEntity<SchoolSection> getHomepage() {
        Optional<SchoolSection> homeSection = service.getSectionByKey("home");
        return homeSection.map(ResponseEntity::ok)
                          .orElse(ResponseEntity.notFound().build());
    }
}

