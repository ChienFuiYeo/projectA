package com.example.payroll.repository;

import com.example.payroll.model.PayslipItem;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.payroll.model.Payslip;

/**
 * Created by yeo on 5/10/2017.
 */
public interface PayslipItemRepository extends MongoRepository<PayslipItem, Long> {

    public Long deletePayslipItemByPayslipItemId(final Long payslipId);
}
