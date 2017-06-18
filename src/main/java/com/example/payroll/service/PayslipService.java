package com.example.payroll.service;

import java.util.List;

import com.example.payroll.model.Payslip;
import com.example.payroll.model.dto.PayslipInsertDTO;

/**
 * Created by yeo on 5/14/2017.
 */
public interface PayslipService {

	public List<Payslip> getAllPayslip();

	public Payslip getByPayslipId(final Long payslipId);

	public String delete(final Long payslipId);

	public Payslip update(Payslip payslip);

	public Payslip insert(PayslipInsertDTO payslipInsertDTO);
}
