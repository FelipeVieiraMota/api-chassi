package com.spring.apichassi.repository;

import com.spring.apichassi.domain.vo.student.StudentEntity;
import com.spring.apichassi.domain.vo.student.StudentEntityPrimaryKeys;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity, StudentEntityPrimaryKeys> {


    Optional<StudentEntity> getStudentByTokenStudent(String tokenStudent);

    Optional<StudentEntity> getStudentByIdStudent(Long idStudent);

}
