package com.example.payroll.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payroll.model.PayslipItem;
import com.example.payroll.model.dto.PayslipItemInsertDTO;
import com.example.payroll.repository.PayslipItemRepository;
import com.example.payroll.service.PayslipItemService;
import com.example.payroll.service.SequenceService;

/**
 * Created by yeo on 5/14/2017.
 */
@Service
public class PayslipItemServiceImpl implements PayslipItemService {

	@Autowired
	private PayslipItemRepository payslipItemRepository;

	@Autowired
	private SequenceService sequenceService;

	@Override
	public List<PayslipItem> getAllPayslipItem() {
		return payslipItemRepository.findAll();
	}

	@Override
	public PayslipItem getByPayslipItemId(Long payslipItemId) {
		return payslipItemRepository.findOne(payslipItemId);
	}

	@Override
	public String delete(Long payslipItemId) {
		if (null == payslipItemRepository.findOne(payslipItemId)) {
			return "PayslipItem not found";
		}
		payslipItemRepository.delete(payslipItemId);
		return "PayslipItem deleted";
	}

	@Override
	public PayslipItem update(PayslipItem payslipItem) {
		return payslipItemRepository.save(payslipItem);
	}

	@Override
	public PayslipItem insert(PayslipItemInsertDTO PayslipItemInsertDTO) {
		PayslipItem payslipItem = new PayslipItem();
		BeanUtils.copyProperties(PayslipItemInsertDTO, payslipItem);
		payslipItem.setPayslipItemId(sequenceService.getPayslipItemNextSeq());
		return payslipItemRepository.insert(payslipItem);
	}
}
