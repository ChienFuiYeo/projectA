package com.example.payroll.service;

/**
 * Created by yeo on 5/10/2017.
 */
public interface SequenceService {

	public Long getStaffNextSeq();

	public Long getJobNextSeq();

	public Long getBranchNextSeq();

	public Long getPayslipNextSeq();

	public Long getPayslipItemNextSeq();
}
