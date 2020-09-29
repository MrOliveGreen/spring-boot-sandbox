package com.dunkware.sandbox.boot.json;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Test class to figure out how to serialize a project
 * object into JSON and simply output the JSON string 
 * to system console. 
 * 
 * @author Duncan Krebs
 *
 */
public class ProjectSerialization {

	
	@Test
	public void testSerialization1() throws Exception { 
		
		Project project = new Project();
		project.setName("Test Project");
		project.setDescription("Test Description");
		project.setStartDate(new Date());
		project.setFinishDate(new Date());
		project.setStatus("Hello World, Good To Be working with you!");
		
		ProjectMilestone milestone1 = new ProjectMilestone();
		milestone1.setDescription("milestone desc");
		milestone1.setFinishDate(new Date());
		milestone1.setStartDate(new Date());
		//milestone1.setName("first milestone");
		// add milestone to project
		project.getMilestones().add(milestone1);
		// lets now run this and see if serialization works
		try {
			// here i am using a default ObjectMapper class to serialize 
			// the instance of the project class to a string of json
			String serialized = new ObjectMapper().writeValueAsString(project);
			// then we simply print out to console lets run it we shuold see status included. 
			System.out.println(serialized);	
			// lets creat a Project instance from the json string 
			Project deserializedProject = new ObjectMapper().readValue(serialized, Project.class);
		
			// the deserialized project instance description should equal the project description
			// that we serialized lets run this!
			System.out.println(deserializedProject.getDescription());
			assertEquals(deserializedProject.getDescription(), project.getDescription());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			// TODO: handle exception
		}
		
	}
}
