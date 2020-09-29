package com.dunkware.sandbox.boot.jpa;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JpaTestComponent {

	@Autowired
	private ProjectRepository projectRepo;
	
	@Autowired
	private ProjectMilestoneRepository milestoneRepo;
	
	// post construct
	// means this method will be
	// called when component is created
	// at startup 
	// we will "auto-wire" the things we need
	@PostConstruct
	public void init() { 
		System.out.println("calling init method");
		ProjectEntity project = new ProjectEntity();
		project.setDescription("My wonderfull project");
		project.setName("My awesome name");
		project.setStartDate(new Date());
		// don't set end date
		// use the save method on project repository to save entity 
		// lets try this!
		projectRepo.save(project);
		
		ProjectMilestoneEntity milestone = new ProjectMilestoneEntity();
		milestone.setName("teset milestone");
		
		milestoneRepo.save(milestone);
	}
}
