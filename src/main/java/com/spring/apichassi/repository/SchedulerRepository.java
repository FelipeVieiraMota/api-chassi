package com.spring.apichassi.repository;

import com.spring.apichassi.domain.vo.Scheduler;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SchedulerRepository extends JpaRepository<Scheduler, Long> {

}
