package com.example.payroll.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.payroll.model.Staff;
import com.example.payroll.model.dto.StaffInsertDTO;
import com.example.payroll.service.StaffService;

/**
 * Created by yeo on 5/10/2017.
 */
@RestController
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	private StaffService staffService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Staff> getStaffs() {
		return staffService.getAllStaff();
	}

	@RequestMapping(value = "{staffId}", method = RequestMethod.GET)
	public Staff getStaff(@PathVariable String staffId) {
		return staffService.getByStaffId(Long.parseLong(staffId));
	}

	@RequestMapping(value = "{staffId}", method = RequestMethod.DELETE)
	public String delete(@PathVariable String staffId) {
		return staffService.delete(Long.parseLong(staffId));
	}

	@RequestMapping(value = "{staffId}", method = RequestMethod.PUT)
	public Staff update(@PathVariable String staffId, @RequestBody Staff staff) {
//		Staff oldStaff = staffService.getByStaffId(Long.parseLong(staffId));
//		if(null != oldStaff){
//			BeanUtils.copyProperties(staff, oldStaff);
//		}
		return staffService.update(staff);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Staff insert(@RequestBody StaffInsertDTO staffInsertDTO) {
		return staffService.insert(staffInsertDTO);
	}
}
