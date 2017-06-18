package com.example.payroll.repository;

import com.example.payroll.model.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by yeo on 5/10/2017.
 */
public interface JobRepository extends MongoRepository<Job, Long> {

    public Long deleteJobByJobId(final Long jobId);
}
