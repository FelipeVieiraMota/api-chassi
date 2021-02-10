package com.spring.apichassi.service;

import com.spring.apichassi.domain.vo.Scheduler;
import com.spring.apichassi.dto.EnveloptedData;
import com.spring.apichassi.dto.SchedulerResponse;
import com.spring.apichassi.repository.SchedulerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class SchedulerService {

    private SchedulerRepository schedulerRepository;

    @Autowired
    public SchedulerService(SchedulerRepository schedulerRepository){
        this.schedulerRepository = schedulerRepository;
    }

    public SchedulerResponse getSchedulerById(Long id){
        Optional<Scheduler> data =  this.schedulerRepository.findById(id);
        return SchedulerResponse.parseResponse(data.get());
    }
}
