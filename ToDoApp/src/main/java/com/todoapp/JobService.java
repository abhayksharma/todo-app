/*This is a service class which implement business logic to create / delete and change the
  Status of Jobs
 */

package com.todoapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    
	@Autowired
	private JobRepo jobRepo;

	public void addTodoJob(String task) {
		Job job = new Job();
		job.setJobDetail(task);
		job.setStatus("p");
		jobRepo.save(job);
	}
	
	public Iterable<Job> getAllJobs() {
		
		return jobRepo.findAll();
	}
	
	
	public void deleteJob(String id) {
		jobRepo.delete(new Integer(id));	
	}
	
	public Job revertJobStatus(String id) {
		try {
			Job job = jobRepo.findOne(new Integer(id));
			if(job!=null) {
				if(job.getStatus().equals("p")) {
					job.setStatus("c");
				}else if(job.getStatus().equals("c")) {
		           job.setStatus("p");		
				}
				jobRepo.save(job);			
			}
			return job;			
		}catch(Exception e) {
			throw e;
		}
	}
	
	
}
