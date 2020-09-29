package com.dunkware.sandbox.boot.json;

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
		
		try {
			String serialized = new ObjectMapper().writeValueAsString(project);
			System.out.println(serialized);	
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			// TODO: handle exception
		}
		
	}
}
