package com.nawale.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nawale.models.SchoolSection;

public interface SchoolSectionRepository extends JpaRepository<SchoolSection, Long> {

	Optional<SchoolSection> findBySectionKey(String key);
	Optional<SchoolSection> findById(int id);
    void deleteBySectionKey(String key);

}
