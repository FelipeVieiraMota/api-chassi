package com.spring.apichassi.dto.student.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.apichassi.domain.vo.student.StudentEntity;
import com.spring.apichassi.domain.vo.student.address.StudentAddressEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentAddressDto {


    @JsonProperty(value = "id_address")
    private Long idAddress;

    @JsonProperty(value = "type")
    private String type;

    @JsonProperty(value = "street")
    private String street;

    @JsonProperty(value = "number")
    private Long number;

    @JsonProperty(value = "neighborhood")
    private String neighborhood;

    @JsonProperty(value = "city")
    private String city;

    @JsonProperty(value = "state")
    private String state;

    @JsonProperty(value = "country")
    private String country;

    @JsonProperty(value = "cep_code")
    private String cepCode;

    @JsonProperty(value = "student")
    private StudentEntity student;

    public static StudentAddressDto parseToStudentAddressDto (StudentAddressEntity address){
        return new StudentAddressDto(
                address.getIdAddress(),
                address.getType(),
                address.getStreet(),
                address.getNumber(),
                address.getNeighborhood(),
                address.getCity(),
                address.getState(),
                address.getCountry(),
                address.getCepCode(),
                address.getStudent()
        );
    }

    public static StudentAddressEntity parseToStudentAddressEntity (StudentAddressDto dto ) {
        return new StudentAddressEntity(
                dto.getIdAddress(),
                dto.getType(),
                dto.getStreet(),
                dto.getNumber(),
                dto.getNeighborhood(),
                dto.getCity(),
                dto.getState(),
                dto.getCountry(),
                dto.getCepCode(),
                dto.getStudent()
        );
    }

    public static StudentAddressDto setIdStudent(Long idStudent, StudentAddressDto address){
        StudentEntity entity = new StudentEntity();
        entity.setIdStudent(idStudent);
        address.setStudent(entity);
        return address;
    }
}
