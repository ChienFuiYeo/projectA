package com.example.payroll.repository;

import com.example.payroll.model.Branch;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.payroll.model.Job;

/**
 * Created by yeo on 5/10/2017.
 */
public interface BranchRepository extends MongoRepository<Branch, Long> {

    public Long deleteBranchByBranchId(final Long jobId);
}
