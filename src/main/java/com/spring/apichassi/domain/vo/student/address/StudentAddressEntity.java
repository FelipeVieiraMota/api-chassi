package com.spring.apichassi.domain.vo.student.address;

import com.spring.apichassi.domain.vo.student.StudentEntity;
import com.spring.apichassi.domain.vo.student.StudentEntityPrimaryKeys;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name="tb_student_address")
@IdClass(StudentAddressEntityPrimaryKeys.class)
public class StudentAddressEntity implements Serializable{

    @ManyToOne
    @JoinColumn(name = "id_student", nullable = false)
    @JoinColumn(name = "token_student", nullable = false)
    private StudentEntity studentEntity;

    @Id
    @Column(name = "id_address", nullable = false)
    private Long idAddress;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "neighborhood", nullable = false)
    private String neighborhood;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "cep_code", nullable = false)
    private String cepCode;
}
