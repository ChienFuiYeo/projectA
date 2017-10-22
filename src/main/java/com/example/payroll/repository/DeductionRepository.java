package com.example.payroll.repository;

import com.example.payroll.model.Deduction;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.payroll.model.Job;

/**
 * Created by yeo on 5/10/2017.
 */
public interface DeductionRepository extends MongoRepository<Deduction, Long> {

    public Long deleteDeductionByDeductionId(final Long deductionId);
}
