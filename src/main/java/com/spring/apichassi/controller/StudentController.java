package com.spring.apichassi.controller;

import com.spring.apichassi.dto.EnvelopedDataDto;
import com.spring.apichassi.dto.StudentDto;
import com.spring.apichassi.service.StudentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/v1/backoffice/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/health_check")
    public ResponseEntity<EnvelopedDataDto<String>> healthCheck(){
        return ResponseEntity.ok(new EnvelopedDataDto<>("Health Check OK!"));
    }

    @GetMapping("/token/{token_student}")
    public ResponseEntity<EnvelopedDataDto<StudentDto>> getStudentByTokenStudent(@PathVariable(name="token_student") String tokenStudent)
            throws NotFoundException {
        return ResponseEntity.ok(new EnvelopedDataDto<>(this.studentService.getStudentByTokenStudent(tokenStudent)));
    }

    @GetMapping("/{id_student}")
    public ResponseEntity<EnvelopedDataDto<StudentDto>> getStudentByIdStudent(@PathVariable(name="id_student") Long idStudent)
            throws NotFoundException {
        return ResponseEntity.ok(new EnvelopedDataDto<>(this.studentService.getStudentByIdStudent(idStudent)));
    }

    @GetMapping()
    public ResponseEntity<EnvelopedDataDto<List<StudentDto>>> getAllStudents() {
        return ResponseEntity.ok(new EnvelopedDataDto<>(this.studentService.getAllStudents()));
    }
}
