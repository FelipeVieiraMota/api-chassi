package com.spring.apichassi.dto.student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.apichassi.domain.vo.student.StudentEntity;
import com.spring.apichassi.dto.student.address.StudentAddressDto;
import com.spring.apichassi.util.Util;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Getter(onMethod = @__({@JsonIgnore}))
    private Date creationDate;

    @JsonProperty(value = "date_creation")
    private String creationDateFormatted;

    @JsonProperty(value = "address")
    //@Setter(onMethod = @__({@JsonIgnore}))
    private StudentAddressDto address;


    public static StudentEntity parseToStudentEntity (StudentDto dto){
        return new StudentEntity(
                dto.getIdStudent(),
                dto.getToken(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getCpf(),
                dto.getRg(),
                dto.getAge(),
                dto.getCreationDate(),
                StudentAddressDto.parseToStudentAddressEntity(dto.getAddress())
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
                studentEntity.getCreationDate(),
                Util.formatDate(studentEntity.getCreationDate()),
                StudentAddressDto.parseToStudentAddressDto(studentEntity.getAddress())
        );
    }
}
