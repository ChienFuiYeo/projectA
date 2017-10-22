package com.example.payroll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.example.payroll.model.Deduction;
import com.example.payroll.model.dto.DeductionInsertDTO;
import com.example.payroll.service.DeductionService;

/**
 * Created by yeo on 5/10/2017.
 */
@RestController
@RequestMapping("/deduction")
public class DeductionController {

	@Autowired
	private DeductionService deductionService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Deduction> getDeductions() {
		return deductionService.getAllDeduction();
	}

	@RequestMapping(value = "{deductionId}", method = RequestMethod.GET)
	public ResponseEntity<Deduction> getDeduction(@PathVariable String deductionId) {
		if (StringUtils.isEmpty(deductionId)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(deductionService.getByDeductionId(Long.parseLong(deductionId)));
	}

	@RequestMapping(value = "{deductionId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable String deductionId) {
		if (null == deductionService.delete(Long.parseLong(deductionId))) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}

	@RequestMapping(value = "{deductionId}", method = RequestMethod.PUT)
	public ResponseEntity<Deduction> update(@PathVariable String deductionId, @RequestBody Deduction deduction) {
		return ResponseEntity.ok(deductionService.update(deduction));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Deduction> insert(@RequestBody DeductionInsertDTO deductionInsertDTO) {
		return ResponseEntity.ok(deductionService.insert(deductionInsertDTO));
	}
}
