package com.spring.apichassi.domain.vo.student.address;

import com.spring.apichassi.domain.vo.student.StudentEntity;
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
public class StudentAddressEntity implements Serializable{

    @Id
    @Column(name = "id_address", nullable = false)
    private Long idAddress;

    @Column(name = "type")
    private String type;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private Long number;

    @Column(name = "neighborhood")
    private String neighborhood;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "cep_code")
    private String cepCode;

    @ManyToOne
    @JoinColumn(name = "id_student", nullable = false)
    private StudentEntity student;
}
