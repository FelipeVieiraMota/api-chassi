package com.spring.apichassi.repository.student.address;

import com.spring.apichassi.domain.vo.student.StudentEntity;
import com.spring.apichassi.domain.vo.student.address.StudentAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentAddressRepository extends JpaRepository<StudentAddressEntity, Long> {

    Optional<StudentAddressEntity> getAddressByStudent(StudentEntity student);
}
