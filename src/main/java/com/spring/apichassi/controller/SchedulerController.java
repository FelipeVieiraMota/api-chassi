package com.spring.apichassi.controller;

import com.spring.apichassi.dto.EnveloptedData;
import com.spring.apichassi.dto.SchedulerResponse;
import com.spring.apichassi.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value="v1/scheduler")
public class SchedulerController {

    private SchedulerService schedulerService;

    @Autowired
    public SchedulerController(SchedulerService schedulerService){
        this.schedulerService = schedulerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchedulerResponse> getSchedulerById(@PathVariable(name="id") Long id){
        SchedulerResponse schedulerData = this.schedulerService.getSchedulerById(id);
        return ResponseEntity.ok(schedulerData);
    }
}
