package com.spring.apichassi.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity(name="tb_student")
@IdClass(StudentEntityPrimaryKeys.class)
public class StudentEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student", nullable = false)
    Long idStudent;

    @Id
    @Column(name = "token_student", updatable = false, nullable = false)
    String tokenStudent;

    @Column(name = "name_student", nullable = false)
    String nameStudent;

    @Column(name = "cpf_student", nullable = false)
    String cpfStudent;

    @Column(name = "rg_student", nullable = false)
    String rgStudent;

    @Column(name = "age_student", nullable = false)
    int ageStudent;
}