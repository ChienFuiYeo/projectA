package com.example.payroll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import com.example.payroll.model.Branch;
import com.example.payroll.model.dto.BranchInsertDTO;
import com.example.payroll.service.BranchService;

/**
 * Created by yeo on 5/10/2017.
 */
@RestController
@RequestMapping("/branch")
public class BranchController {

	@Autowired
	private BranchService branchService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Branch> getBranchs() {
		return branchService.getAllBranch();
	}

	@RequestMapping(value = "{branchId}", method = RequestMethod.GET)
	public Branch getBranch(@PathVariable Long branchId) {
		return branchService.getByBranchId(branchId);
	}

	@RequestMapping(value = "{branchId}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Long branchId) {
		return branchService.delete(branchId);
	}

	@RequestMapping(value = "{branchId}", method = RequestMethod.PUT)
	public Branch update(@RequestBody Branch branch) {
		return branchService.update(branch);
	}

	@RequestMapping( method = RequestMethod.POST)
	public Branch insert(@RequestBody BranchInsertDTO branchInsertDTO) {
		return branchService.insert(branchInsertDTO);
	}
}
