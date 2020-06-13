package com.yavoid.crudapi.service;

import com.yavoid.crudapi.model.Student;
import com.yavoid.crudapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student findById(long id) {
        return repository.getOne(id);
    }

    public List<Student> findAll() {
        return repository.findAll();
    }

    public Student append(Student student) {
        return repository.save(student);
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
