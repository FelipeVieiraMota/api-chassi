package com.spring.apichassi.repository.student.address;

import com.spring.apichassi.domain.vo.student.address.StudentAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentAddressRepository extends JpaRepository<StudentAddressEntity, Long> {

}
