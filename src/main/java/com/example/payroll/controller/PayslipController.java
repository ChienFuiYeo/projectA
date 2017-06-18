package com.example.payroll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.payroll.model.Payslip;
import com.example.payroll.model.dto.PayslipInsertDTO;
import com.example.payroll.service.PayslipService;

/**
 * Created by yeo on 5/10/2017.
 */
@RestController
@RequestMapping("/payslip")
public class PayslipController {

	@Autowired
	private PayslipService payslipService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Payslip> getPayslips() {
		return payslipService.getAllPayslip();
	}

	@RequestMapping(value = "{payslipId}", method = RequestMethod.GET)
	public Payslip getPayslip(@PathVariable Long payslipId) {
		return payslipService.getByPayslipId(payslipId);
	}

	@RequestMapping(value = "{payslipId}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Long payslipId) {
		return payslipService.delete(payslipId);
	}

	@RequestMapping(value = "{payslipId}", method = RequestMethod.PUT)
	public Payslip update(@RequestBody Payslip payslip) {
		return payslipService.update(payslip);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Payslip insert(@RequestBody PayslipInsertDTO payslipInsertDTO) {
		return payslipService.insert(payslipInsertDTO);
	}
}
