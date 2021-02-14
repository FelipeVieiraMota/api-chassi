package com.spring.apichassi.dto.student.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.apichassi.domain.vo.student.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentAddressDto {

    @JsonProperty(value = "id_student")
    Long idStudent;

    @JsonProperty(value = "token_student")
    String tokenStudent;

    @JsonProperty(value = "first_name_student")
    String firstNameStudent;

    @JsonProperty(value = "last_name_student")
    String lastNameStudent;

    @JsonProperty(value = "cpf_student")
    String cpfStudent;

    @JsonProperty(value = "rg_student")
    String rgStudent;

    @JsonProperty(value = "age_student")
    int ageStudent;

    public static StudentAddressDto parseToStudentDto (StudentEntity studentEntity){
        return new StudentAddressDto(
                studentEntity.getIdStudent(),
                studentEntity.getTokenStudent(),
                studentEntity.getFirstNameStudent(),
                studentEntity.getLastNameStudent(),
                studentEntity.getCpfStudent(),
                studentEntity.getRgStudent(),
                studentEntity.getAgeStudent()
        );
    }
}
