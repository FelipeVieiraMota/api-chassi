package com.spring.apichassi.repository;

import com.spring.apichassi.domain.vo.StudentEntity;
import com.spring.apichassi.domain.vo.StudentEntityPrimaryKeys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity, StudentEntityPrimaryKeys> {


    Optional<StudentEntity> getStudentByTokenStudent(String tokenStudent);

    Optional<StudentEntity> getStudentByIdStudent(Long idStudent);

}
