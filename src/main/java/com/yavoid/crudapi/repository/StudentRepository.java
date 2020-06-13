package com.yavoid.crudapi.repository;

import com.yavoid.crudapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
