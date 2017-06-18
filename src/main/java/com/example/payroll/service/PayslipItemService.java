package com.example.payroll.service;

import java.util.List;

import com.example.payroll.model.PayslipItem;
import com.example.payroll.model.dto.PayslipItemInsertDTO;

/**
 * Created by yeo on 5/14/2017.
 */
public interface PayslipItemService {

	public List<PayslipItem> getAllPayslipItem();

	public PayslipItem getByPayslipItemId(final Long payslipItemId);

	public String delete(final Long payslipItemId);

	public PayslipItem update(PayslipItem payslipItem);

	public PayslipItem insert(PayslipItemInsertDTO payslipItemInsertDTO);
}
