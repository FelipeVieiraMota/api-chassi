package com.spring.apichassi.service;

import com.spring.apichassi.domain.vo.student.StudentEntity;
import com.spring.apichassi.dto.student.StudentDto;
import com.spring.apichassi.repository.StudentRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public StudentDto getStudentByTokenStudent(String tokenStudent) throws NotFoundException {
        Optional<StudentEntity> data =  this.studentRepository.getStudentByTokenStudent(tokenStudent);
        data.orElseThrow(() -> new NotFoundException("There are not user with token = "+ tokenStudent));
        return StudentDto.parseToStudentDto(data.get());
    }

    public StudentDto getStudentByIdStudent(Long idStudent) throws NotFoundException {
        Optional<StudentEntity> data =  this.studentRepository.getStudentByIdStudent(idStudent);
        data.orElseThrow(() -> new NotFoundException("There are not user with id = "+ idStudent));
        return StudentDto.parseToStudentDto(data.get());
    }

    public List<StudentDto> getAllStudents()  {
        List<StudentEntity> data =  this.studentRepository.findAll();
        List<StudentDto> listDto = new ArrayList<>();
        data.forEach( student -> {
            StudentDto dto = StudentDto.parseToStudentDto(student);
            listDto.add(dto);
        });
        return listDto;
    }

    public StudentDto saveStudent(StudentDto student){
        StudentEntity entity = this.studentRepository.save(StudentDto.parseToStudentEntity(student));
        return StudentDto.parseToStudentDto(entity);
    }
}
