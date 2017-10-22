package com.example.payroll.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payroll.model.Deduction;
import com.example.payroll.model.dto.DeductionInsertDTO;
import com.example.payroll.repository.DeductionRepository;
import com.example.payroll.service.DeductionService;
import com.example.payroll.service.SequenceService;

/**
 * Created by yeo on 5/14/2017.
 */
@Service
public class DeductionServiceImpl implements DeductionService {

	@Autowired
	private DeductionRepository deductionRepository;

	@Autowired
	private SequenceService sequenceService;

	@Override
	public List<Deduction> getAllDeduction() {
		return deductionRepository.findAll();
	}

	@Override
	public Deduction getByDeductionId(Long deductionId) {
		return deductionRepository.findOne(deductionId);
	}

	@Override
	public String delete(Long deductionId) {
		if (null == deductionRepository.findOne(deductionId)) {
			return "Deduction not found";
		}
		deductionRepository.delete(deductionId);
		return "Deduction deleted";
	}

	@Override
	public Deduction update(Deduction deduction) {
		return deductionRepository.save(deduction);
	}

	@Override
	public Deduction insert(DeductionInsertDTO deductionInsertDTO) {
		Deduction deduction = new Deduction();
		BeanUtils.copyProperties(deductionInsertDTO, deduction);
		deduction.setDeductionId(sequenceService.getDeductionNextSeq());
		return deductionRepository.insert(deduction);
	}
}
