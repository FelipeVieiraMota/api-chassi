package com.spring.apichassi.controller;

import com.spring.apichassi.domain.vo.StudentEntity;
import com.spring.apichassi.dto.EnvelopedData;
import com.spring.apichassi.service.StudentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/v1/backoffice/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/health_check")
    public ResponseEntity<EnvelopedData<String>> healthCheck(){
        return ResponseEntity.ok(new EnvelopedData<>("Health Check OK!"));
    }

    @GetMapping("/token/{token_student}")
    public ResponseEntity<EnvelopedData<StudentEntity>> getStudentByToken(@PathVariable(name="token_student") String tokenStudent) throws NotFoundException {
        return ResponseEntity.ok(new EnvelopedData<>(this.studentService.getStudentByIdToken(null, tokenStudent)));
    }

    @GetMapping("/{id_student}")
    public ResponseEntity<EnvelopedData<StudentEntity>> getStudentById(@PathVariable(name="id_student") Long idStudent) throws NotFoundException {
        return ResponseEntity.ok(new EnvelopedData<>(this.studentService.getStudentByIdToken(idStudent,null)));
    }
}
