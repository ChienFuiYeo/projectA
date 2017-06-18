package com.example.payroll.repository;

import com.example.payroll.model.Staff;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by yeo on 5/10/2017.
 */
public interface StaffRepository extends MongoRepository<Staff, Long> {

    public Long deleteStaffByStaffId(final Long staffId);
}
