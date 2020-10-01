package com.dunkware.sandbox.boot.jpa;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dunkware.sandbox.boot.jpa.milestone.repository.MilestoneRepository;
import com.dunkware.sandbox.boot.jpa.model.milestone.MilestoneEntity;
import com.dunkware.sandbox.boot.jpa.model.project.ProjectEntity;
import com.dunkware.sandbox.boot.jpa.project.repository.ProjectRepository;

@Component
public class JpaTestComponent {

	@Autowired(required = true)
	private ProjectRepository projectRepo;
	
	@Autowired(required = true)
	private MilestoneRepository milestoneRepo;
	
	// post construct  
	// means this method will be
	// called when component is created
	// at startup 
	// we will "auto-wire" the things we need
	//@Test
	@PostConstruct
	public void init() { 
		System.out.println("calling init method");
		ProjectEntity project = new ProjectEntity();
		project.setDescription("My wonderful project");
		project.setName("My awesome name");
		project.setStartDate(new Date());
		// don't set end date
		// use the save method on project repository to save entity 
		// lets try this!
		projectRepo.save(project);
		System.out.println("-- Project Saved --");
		
		MilestoneEntity milestone = new MilestoneEntity();
		milestone.setName("teset milestone");
		
		milestoneRepo.save(milestone);
		System.out.println("-- Project Milestone Saved --");
	}
}
