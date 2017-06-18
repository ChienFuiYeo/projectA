package com.example.payroll.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.payroll.model.Staff;
import com.example.payroll.model.dto.StaffInsertDTO;
import com.example.payroll.repository.StaffRepository;
import com.example.payroll.service.SequenceService;
import com.example.payroll.service.StaffService;
import org.springframework.stereotype.Service;

/**
 * Created by yeo on 5/14/2017.
 */
@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private SequenceService sequenceService;

	@Override
	public List<Staff> getAllStaff() {
		return staffRepository.findAll();
	}

	@Override
	public Staff getByStaffId(Long staffId) {
		return staffRepository.findOne(staffId);
	}

	@Override
	public String delete(Long staffId) {
		if (null == staffRepository.findOne(staffId)) {
			return "Staff not found";
		}
		staffRepository.delete(staffId);
		return "Staff deleted";
	}

	@Override
	public Staff update(Staff staff) {
		return staffRepository.save(staff);
	}

	@Override
	public Staff insert(StaffInsertDTO staffInsertDTO) {
		Staff staff = new Staff();
		BeanUtils.copyProperties(staffInsertDTO, staff);
		staff.setStaffId(sequenceService.getStaffNextSeq());
		return staffRepository.insert(staff);
	}
}
