package com.example.payroll.service;

import com.example.payroll.model.Staff;
import com.example.payroll.model.dto.StaffInsertDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yeo on 5/14/2017.
 */
public interface StaffService {

    public List<Staff> getAllStaff();

    public Staff getByStaffId(final Long staffId);

    public String delete(final Long staffId);

    public Staff update(Staff staff);

    public Staff insert(StaffInsertDTO staffInsertDTO);
}
