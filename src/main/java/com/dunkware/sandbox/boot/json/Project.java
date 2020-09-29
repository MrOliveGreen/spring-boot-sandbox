package com.dunkware.sandbox.boot.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * This is a simple java class 
 * with getters/setters for the private
 * variable members. 
 * @author dkrebs
 *
 */
public class Project {

	private String name; 
	private String description; 
	private Date startDate;
	private Date finishDate;
	// adding a status string
	// then I'm going to add a set and get method like this ..
	private String status; 
	
	private List<ProjectMilestone> milestones = new ArrayList<ProjectMilestone>();
	
	public Project() { 
		
	}
	
	
	
	public List<ProjectMilestone> getMilestones() {
		return milestones;
	}




	public void setMilestones(List<ProjectMilestone> milestones) {
		this.milestones = milestones;
	}




	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	
	
}
