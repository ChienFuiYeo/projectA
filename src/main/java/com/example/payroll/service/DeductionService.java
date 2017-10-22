package com.example.payroll.service;

import java.util.List;

import com.example.payroll.model.Deduction;
import com.example.payroll.model.dto.DeductionInsertDTO;

/**
 * Created by yeo on 5/14/2017.
 */
public interface DeductionService {

	public List<Deduction> getAllDeduction();

	public Deduction getByDeductionId(final Long deductionId);

	public String delete(final Long deductionId);

	public Deduction update(Deduction deduction);

	public Deduction insert(DeductionInsertDTO deductionInsertDTO);
}
