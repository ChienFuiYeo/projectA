package com.example.payroll.repository;

import com.example.payroll.model.Payslip;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.payroll.model.Branch;

/**
 * Created by yeo on 5/10/2017.
 */
public interface PayslipRepository extends MongoRepository<Payslip, Long> {

    public Long deletePayslipByPayslipId(final Long payslipId);
}
