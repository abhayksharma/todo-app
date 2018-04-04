/*This is a Rest Controller class which keeps the methods mapped against REST URIs*/
package com.todoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoCtl {

	@Autowired
	private JobService jobService;
	

	@RequestMapping(value="/job/{description}", method=RequestMethod.GET)
	public String addJob(@PathVariable String description) {
		jobService.addTodoJob(description);
		return "{\"status\":\"OK\",\"message\":\"Job added successfully\"}";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/job/all")
	public Iterable<Job> getAllJobs(){
		return jobService.getAllJobs();
	}

	@RequestMapping(value="/job/{jobId}", method=RequestMethod.DELETE)
	public String deleteJob(@PathVariable String jobId) {
		jobService.deleteJob(jobId);
		return "{\"status\":\"OK\",\"message\":\"Job deleted successfully\"}";
	}
	
	@RequestMapping(value="/job/status/{jobId}", method=RequestMethod.GET)
	public ResponseEntity<Job> revertJobStatus(@PathVariable String jobId) {
		ResponseEntity<Job> resp = null;
		try {
			Job job = jobService.revertJobStatus(jobId);
			if(job!=null) {
			  resp = new ResponseEntity<Job>(job,HttpStatus.OK);
			}else {
				resp = new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
			}
		}catch(Exception e){
			resp = new ResponseEntity<Job>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
}
