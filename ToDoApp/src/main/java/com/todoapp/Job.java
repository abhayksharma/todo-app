/*This is a model class representing the Job object */
package com.todoapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;


@Entity
public class Job {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String jobDetail;
    private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Job() {}
	
	public Job(Integer id, String jobDetail,String status) {
		super();
		this.id = id;
		this.jobDetail = jobDetail;
		this.status = status;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getJobDetail() {
		return jobDetail;
	}
	public void setJobDetail(String jobDetail) {
		this.jobDetail = jobDetail;
	}
}
