package com.batch.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cone {
	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job helloWorldJob;
	
	@GetMapping(path="/")
	public String one()throws Exception  {
		JobParameters jobParameters = new JobParametersBuilder().toJobParameters();
		jobLauncher.run(helloWorldJob, jobParameters);
		return "Started";
	}
}
