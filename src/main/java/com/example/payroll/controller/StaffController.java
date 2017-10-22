package com.example.payroll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
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
	public ResponseEntity<Staff> getStaff(@PathVariable String staffId) {
		if (StringUtils.isEmpty(staffId)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(staffService.getByStaffId(Long.parseLong(staffId)));
	}

	@RequestMapping(value = "{staffId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable String staffId) {
		if (null == staffService.delete(Long.parseLong(staffId))) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}

	@RequestMapping(value = "{staffId}", method = RequestMethod.PUT)
	public ResponseEntity<Staff> update(@PathVariable String staffId, @RequestBody Staff staff) {
		return ResponseEntity.ok(staffService.update(staff));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Staff> insert(@RequestBody StaffInsertDTO staffInsertDTO) {
		return ResponseEntity.ok(staffService.insert(staffInsertDTO));
	}
}
