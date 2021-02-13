package com.spring.apichassi.service;

import com.spring.apichassi.domain.vo.StudentEntity;
import com.spring.apichassi.domain.vo.StudentEntityPrimaryKeys;
import com.spring.apichassi.repository.StudentRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public StudentEntity getStudentByIdToken(Long idStudent, String tokenStudent) throws NotFoundException {
        StudentEntityPrimaryKeys keys = new StudentEntityPrimaryKeys(idStudent, tokenStudent);
        Optional<StudentEntity> data =  this.studentRepository.findById(keys);
        return data.orElseThrow(() -> new NotFoundException("There are not user with token_student = "+ tokenStudent));
    }

}
