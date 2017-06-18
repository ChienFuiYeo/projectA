package com.example.payroll.controller;

import java.util.List;

import com.example.payroll.model.dto.JobInsertDTO;
import com.example.payroll.service.JobService;
import com.example.payroll.service.StaffService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.payroll.model.Job;
import com.example.payroll.repository.JobRepository;
import com.example.payroll.service.SequenceService;

/**
 * Created by yeo on 5/10/2017.
 */
@RestController
@RequestMapping("/job")
public class JobController {

	@Autowired
	private JobService jobService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Job> getJobs() {
		return jobService.getAllJob();
	}

	@RequestMapping(value = "{jobId}", method = RequestMethod.GET)
	public Job getJob(@PathVariable Long jobId) {
		return jobService.getByJobId(jobId);
	}

	@RequestMapping(value = "{jobId}/delete", method = RequestMethod.PUT)
	public String delete(@PathVariable Long jobId) {
		return jobService.delete(jobId);
	}

	@RequestMapping(value = "update", method = RequestMethod.PUT)
	public Job update(@RequestBody Job job) {
		return jobService.update(job);
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public Job insert(@RequestBody JobInsertDTO jobInsertDTO) {
		return jobService.insert(jobInsertDTO);
	}
}
