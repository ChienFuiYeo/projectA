package com.example.payroll.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.payroll.model.Job;
import com.example.payroll.model.dto.JobInsertDTO;

/**
 * Created by yeo on 5/14/2017.
 */
public interface JobService {

	public List<Job> getAllJob();

	public Job getByJobId(final Long jobId);

	public String delete(final Long jobId);

	public Job update(Job job);

	public Job insert(JobInsertDTO jobInsertDTO);
}
