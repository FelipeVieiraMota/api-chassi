package com.spring.apichassi.service.student;

import com.spring.apichassi.domain.vo.student.StudentEntity;
import com.spring.apichassi.domain.vo.student.address.StudentAddressEntity;
import com.spring.apichassi.dto.student.StudentDto;
import com.spring.apichassi.dto.student.address.StudentAddressDto;
import com.spring.apichassi.repository.student.StudentRepository;
import com.spring.apichassi.repository.student.address.StudentAddressRepository;
import com.spring.apichassi.util.Util;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    private StudentAddressRepository studentAddressRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, StudentAddressRepository studentAddressRepository){
        this.studentRepository = studentRepository;
        this.studentAddressRepository = studentAddressRepository;
    }

    public StudentDto getStudentByTokenStudent(String tokenStudent) throws NotFoundException {
        Optional<StudentEntity> data =  this.studentRepository.getStudentByToken(tokenStudent);
        data.orElseThrow(() -> new NotFoundException("There are not user with token = "+ tokenStudent));
        return StudentDto.parseToStudentDto(data.get());
    }

    public StudentDto getStudentByIdStudent(Long idStudent) throws NotFoundException {
        Optional<StudentEntity> data =  this.studentRepository.getStudentByIdStudent(idStudent);
        data.orElseThrow(() -> new NotFoundException("There are not user with id = "+ idStudent));
        return StudentDto.parseToStudentDto(data.get());
    }

    public List<StudentDto> getAllStudents() {
        List<StudentEntity> data =  this.studentRepository.findAll();
        List<StudentDto> listDto = new ArrayList<>();
        data.forEach( student -> {
            StudentAddressEntity address = getAddressByIdStudent(student.getIdStudent());
            student.setAddress(address);
            StudentDto dto = StudentDto.parseToStudentDto(student);
            listDto.add(dto);
        });
        return listDto;
    }

    public StudentDto saveStudent(StudentDto student){
        student.setToken(Util.uuidGenerator());
        student.setCreationDate(Util.getCurrentDateTime());
        StudentEntity entity = this.studentRepository.save(StudentDto.parseToStudentEntity(student));
        return StudentDto.parseToStudentDto(entity);
    }

    public StudentAddressDto saveAddress(Long idStudent, StudentAddressDto address){
        StudentAddressDto parsedAddress = StudentAddressDto.setIdStudent(idStudent, address);
        StudentAddressEntity entity = StudentAddressDto.parseToStudentAddressEntity(parsedAddress);
        StudentAddressDto saved = StudentAddressDto.parseToStudentAddressDto(this.studentAddressRepository.save(entity));
        return saved;
    }

    public StudentAddressEntity getAddressByIdStudent(Long idStudent){
        StudentEntity entity = new StudentEntity();
        entity.setIdStudent(idStudent);
        Optional<StudentAddressEntity> opt = this.studentAddressRepository.getAddressByStudent(entity);
        return opt.get();
    }
}
