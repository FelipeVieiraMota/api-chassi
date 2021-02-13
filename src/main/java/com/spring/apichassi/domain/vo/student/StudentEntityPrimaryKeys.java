package com.spring.apichassi.domain.vo.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentEntityPrimaryKeys implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idStudent;
    private String tokenStudent;
}
