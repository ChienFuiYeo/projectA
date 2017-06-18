package com.example.payroll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.payroll.model.PayslipItem;
import com.example.payroll.model.dto.PayslipItemInsertDTO;
import com.example.payroll.service.PayslipItemService;

/**
 * Created by yeo on 5/10/2017.
 */
@RestController
@RequestMapping("/payslipItem")
public class PayslipItemController {

	@Autowired
	private PayslipItemService payslipItemService;

	@RequestMapping(method = RequestMethod.GET)
	public List<PayslipItem> getPayslipItems() {
		return payslipItemService.getAllPayslipItem();
	}

	@RequestMapping(value = "{payslipItemId}", method = RequestMethod.GET)
	public PayslipItem getPayslipItem(@PathVariable Long payslipItemId) {
		return payslipItemService.getByPayslipItemId(payslipItemId);
	}

	@RequestMapping(value = "{payslipItemId}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Long payslipItemId) {
		return payslipItemService.delete(payslipItemId);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public PayslipItem update(@RequestBody PayslipItem payslipItem) {
		return payslipItemService.update(payslipItem);
	}

	@RequestMapping(method = RequestMethod.POST)
	public PayslipItem insert(@RequestBody PayslipItemInsertDTO payslipItemInsertDTO) {
		return payslipItemService.insert(payslipItemInsertDTO);
	}
}
