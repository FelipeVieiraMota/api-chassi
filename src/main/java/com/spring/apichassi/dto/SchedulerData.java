package com.spring.apichassi.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.apichassi.domain.vo.Scheduler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class SchedulerData {

    @JsonProperty("id_scheduler")
    private Long idScheduler;

    @JsonProperty("name")
    private String name;

    @JsonProperty("number")
    private Long number;

    @JsonProperty("email")
    private String email;

    @JsonProperty("description")
    private String description;

    public static SchedulerData parseSchedulerData(Scheduler scheduler){
        return new SchedulerData(
                scheduler.getIdScheduler(),
                scheduler.getName(),
                scheduler.getNumber(),
                scheduler.getDescription(),
                scheduler.getEmail()
        );
    }

    public static Scheduler parseScheduler(SchedulerData schedulerData){
        return new Scheduler(
                null,
                schedulerData.getName(),
                schedulerData.getNumber(),
                schedulerData.getDescription(),
                schedulerData.getEmail()
        );
    }
}
