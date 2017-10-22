package com.example.payroll.controller;

import java.util.List;

import com.example.payroll.model.Staff;
import com.example.payroll.model.dto.StaffInsertDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.example.payroll.model.Job;
import com.example.payroll.model.dto.JobInsertDTO;
import com.example.payroll.service.JobService;

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

	@RequestMapping(value = "{staffId}", method = RequestMethod.GET)
	public ResponseEntity<Job> getStaff(@PathVariable String jobId) {
		if (StringUtils.isEmpty(jobId)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(jobService.getByJobId(Long.parseLong(jobId)));
	}

	@RequestMapping(value = "{staffId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable String staffId) {
		if (null == jobService.delete(Long.parseLong(staffId))) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}

	@RequestMapping(value = "{staffId}", method = RequestMethod.PUT)
	public ResponseEntity<Job> update(@PathVariable String staffId, @RequestBody Job job) {
		return ResponseEntity.ok(jobService.update(job));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Job> insert(@RequestBody JobInsertDTO jobInsertDTO) {
		return ResponseEntity.ok(jobService.insert(jobInsertDTO));
	}
}
