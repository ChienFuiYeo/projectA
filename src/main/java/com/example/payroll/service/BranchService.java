package com.example.payroll.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.payroll.model.Branch;
import com.example.payroll.model.dto.BranchInsertDTO;

/**
 * Created by yeo on 5/14/2017.
 */
public interface BranchService {

	public List<Branch> getAllBranch();

	public Branch getByBranchId(final Long branchId);

	public String delete(final Long branchId);

	public Branch update(Branch branch);

	public Branch insert(BranchInsertDTO branchInsertDTO);
}
