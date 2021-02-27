package com.spring.apichassi.dto.student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.apichassi.domain.vo.student.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String creationDate;

    @JsonProperty(value = "date_creation")
    private String creationDateFormatted;


    public static StudentEntity parseToStudentEntity (StudentDto dto){
        return new StudentEntity(
                dto.getIdStudent(),
                dto.getToken(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getCpf(),
                dto.getRg(),
                dto.getAge(),
                dto.getCreationDate()
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
                studentEntity.getCreationDate()
        );
    }
}
