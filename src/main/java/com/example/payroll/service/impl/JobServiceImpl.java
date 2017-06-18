package com.example.payroll.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.payroll.model.Job;
import com.example.payroll.model.dto.JobInsertDTO;
import com.example.payroll.repository.JobRepository;
import com.example.payroll.service.JobService;
import com.example.payroll.service.SequenceService;
import org.springframework.stereotype.Service;

/**
 * Created by yeo on 5/14/2017.
 */
@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobRepository jobRepository;

	@Autowired
	private SequenceService sequenceService;

	@Override
	public List<Job> getAllJob() {
		return jobRepository.findAll();
	}

	@Override
	public Job getByJobId(Long jobId) {
		return jobRepository.findOne(jobId);
	}

	@Override
	public String delete(Long jobId) {
		if (null == jobRepository.findOne(jobId)) {
			return "Job not found";
		}
		jobRepository.delete(jobId);
		return "Job deleted";
	}

	@Override
	public Job update(Job job) {
		return jobRepository.save(job);
	}

	@Override
	public Job insert(JobInsertDTO JobInsertDTO) {
		Job job = new Job();
		BeanUtils.copyProperties(JobInsertDTO, job);
		job.setJobId(sequenceService.getJobNextSeq());
		return jobRepository.insert(job);
	}
}
