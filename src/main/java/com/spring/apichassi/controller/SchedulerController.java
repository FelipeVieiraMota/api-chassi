package com.spring.apichassi.controller;

import com.spring.apichassi.domain.vo.Scheduler;
import com.spring.apichassi.dto.EnveloptedData;
import com.spring.apichassi.dto.SchedulerData;
import com.spring.apichassi.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value="/v1/scheduler")
public class SchedulerController {

    private SchedulerService schedulerService;

    @Autowired
    public SchedulerController(SchedulerService schedulerService){
        this.schedulerService = schedulerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchedulerData> getSchedulerById(@PathVariable(name="id") Long id){
        SchedulerData schedulerData = this.schedulerService.getSchedulerById(id);
        return ResponseEntity.ok(schedulerData);
    }

    @GetMapping()
    public ResponseEntity createScheduler(@RequestBody SchedulerData schedulerData){
        Scheduler scheduler = this.schedulerService.createScheduler(schedulerData);
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduler);
    }
}
