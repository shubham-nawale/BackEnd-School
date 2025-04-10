package com.nawale.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nawale.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
