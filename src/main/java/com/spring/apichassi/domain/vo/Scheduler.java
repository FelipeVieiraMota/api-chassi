package com.spring.apichassi.domain.vo;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name="tb_scheduler")
public class Scheduler implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_scheduler")
    private Long idScheduler;

    @Column(length = 75, nullable = false)
    private String name;

    @Column(nullable = false)
    private Long number;

    @Column(length = 75, nullable = false, unique = true)
    private String email;

    @Column(columnDefinition = "text")
    private String description;
}
