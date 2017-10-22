package com.example.payroll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
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
	public ResponseEntity<Branch> getBranch(@PathVariable String branchId) {
		if (StringUtils.isEmpty(branchId)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(branchService.getByBranchId(Long.parseLong(branchId)));
	}

	@RequestMapping(value = "{branchId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable String branchId) {
		if (null == branchService.delete(Long.parseLong(branchId))) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}

	@RequestMapping(value = "{branchId}", method = RequestMethod.PUT)
	public ResponseEntity<Branch> update(@PathVariable String branchId, @RequestBody Branch branch) {
		return ResponseEntity.ok(branchService.update(branch));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Branch> insert(@RequestBody BranchInsertDTO branchInsertDTO) {
		return ResponseEntity.ok(branchService.insert(branchInsertDTO));
	}
}
