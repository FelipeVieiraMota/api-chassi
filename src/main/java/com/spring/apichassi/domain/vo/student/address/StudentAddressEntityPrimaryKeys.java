package com.spring.apichassi.domain.vo.student.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentAddressEntityPrimaryKeys implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long idAddress;
}