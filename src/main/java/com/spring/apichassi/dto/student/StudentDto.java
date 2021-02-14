package com.spring.apichassi.dto.student;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.apichassi.domain.vo.student.StudentEntity;
import com.spring.apichassi.util.Util;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDto {

    @JsonProperty(value = "id_student")
    Long idStudent;

    @JsonProperty(value = "token")
    String token;

    @JsonProperty(value = "first_name")
    String firstName;

    @JsonProperty(value = "last_name")
    String lastName;

    @JsonProperty(value = "cpf")
    String cpf;

    @JsonProperty(value = "rg")
    String rg;

    @JsonProperty(value = "age")
    int age;

    @JsonProperty(value = "creation_date")
    private Date creationDate;


    public static StudentEntity parseToStudentEntity (StudentDto dto){
        return new StudentEntity(
                null,
                Util.uuidGenerator(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getCpf(),
                dto.getRg(),
                dto.getAge(),
                null
        );
    }

    public static StudentDto parseToStudentDto (StudentEntity studentEntity){
        return new StudentDto(
                studentEntity.getIdStudent(),
                studentEntity.getToken(),
                studentEntity.getFirstName(),
                studentEntity.getLastName(),
                studentEntity.getCpf(),
                studentEntity.getRg(),
                studentEntity.getAge(),
                studentEntity.getCreationDate()
        );
    }
}
