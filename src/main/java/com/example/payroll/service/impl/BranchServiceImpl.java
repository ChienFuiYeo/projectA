package com.example.payroll.service.impl;

import java.util.List;

import com.example.payroll.model.dto.BranchInsertDTO;
import com.example.payroll.service.BranchService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.payroll.model.Branch;
import com.example.payroll.repository.BranchRepository;
import com.example.payroll.service.SequenceService;
import org.springframework.stereotype.Service;

/**
 * Created by yeo on 5/14/2017.
 */
@Service
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchRepository branchRepository;

	@Autowired
	private SequenceService sequenceService;

	@Override
	public List<Branch> getAllBranch() {
		return branchRepository.findAll();
	}

	@Override
	public Branch getByBranchId(Long branchId) {
		return branchRepository.findOne(branchId);
	}

	@Override
	public String delete(Long branchId) {
		if (null == branchRepository.findOne(branchId)) {
			return "Branch not found";
		}
		branchRepository.delete(branchId);
		return "Branch deleted";
	}

	@Override
	public Branch update(Branch branch) {
		return branchRepository.save(branch);
	}

	@Override
	public Branch insert(BranchInsertDTO BranchInsertDTO) {
		Branch branch = new Branch();
		BeanUtils.copyProperties(BranchInsertDTO, branch);
		branch.setBranchId(sequenceService.getBranchNextSeq());
		return branchRepository.insert(branch);
	}
}
