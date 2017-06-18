package com.example.payroll.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payroll.model.Payslip;
import com.example.payroll.model.dto.PayslipInsertDTO;
import com.example.payroll.repository.PayslipRepository;
import com.example.payroll.service.PayslipService;
import com.example.payroll.service.SequenceService;

/**
 * Created by yeo on 5/14/2017.
 */
@Service
public class PayslipServiceImpl implements PayslipService {

	@Autowired
	private PayslipRepository payslipRepository;

	@Autowired
	private SequenceService sequenceService;

	@Override
	public List<Payslip> getAllPayslip() {
		return payslipRepository.findAll();
	}

	@Override
	public Payslip getByPayslipId(Long payslipId) {
		return payslipRepository.findOne(payslipId);
	}

	@Override
	public String delete(Long payslipId) {
		if (null == payslipRepository.findOne(payslipId)) {
			return "Payslip not found";
		}
		payslipRepository.delete(payslipId);
		return "Payslip deleted";
	}

	@Override
	public Payslip update(Payslip payslip) {
		return payslipRepository.save(payslip);
	}

	@Override
	public Payslip insert(PayslipInsertDTO PayslipInsertDTO) {
		Payslip payslip = new Payslip();
		BeanUtils.copyProperties(PayslipInsertDTO, payslip);
		payslip.setPayslipId(sequenceService.getPayslipNextSeq());
		return payslipRepository.insert(payslip);
	}
}
