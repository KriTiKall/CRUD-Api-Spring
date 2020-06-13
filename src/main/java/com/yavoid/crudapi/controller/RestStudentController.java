package com.yavoid.crudapi.controller;

import com.yavoid.crudapi.model.Student;
import com.yavoid.crudapi.service.StudentService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class RestStudentController {

    private final StudentService service;

    @Autowired
    public RestStudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return service.findAll();
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable Long id) {
        Hibernate.initialize(service.findById(id));
        return service.findById(id);
    }

    @PostMapping("/student/new")
    public List<Student> create(@RequestBody Student student) {
        service.append(student);
        return service.findAll();
    }

    @PutMapping("student/{id}")
    public List<Student> update(@PathVariable Long id, @RequestBody Student student) {
        if (service.findById(id) != null)
            service.append(student);
        return service.findAll();
    }

    @DeleteMapping("student/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
