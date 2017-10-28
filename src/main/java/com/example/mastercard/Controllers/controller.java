package com.example.mastercard.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.mastercard.Repositories.studentRepository;
import com.example.mastercard.Models.Students;
import java.util.List;


@RestController //Used to indicate that this is the controller class
public class controller {
	@Autowired 
	private studentRepository repository;

	
	//GET request which retrieves all the students in the repository. Returns 200 OK status if successfully retrieved 
	@RequestMapping(value="/Students", method = RequestMethod.GET)
	public ResponseEntity<List<Students>> getStudents()
	{
		List<Students> students =  (List<Students>) repository.findAll();
		if(students.isEmpty())
		{
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity(students, HttpStatus.OK);
	}
	
	//GET request which retrieves a specific student via id. Returns 404 NOT FOUND status if no student has the ID.
	@RequestMapping(value="/Students/{id}", method = RequestMethod.GET)
	public ResponseEntity<Students> getStudentByID(@PathVariable Integer id)
	{
		Students student =  repository.findOne(id);
		if(student == null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	//POST method which creates a user and saves it into the repository. Returns 201 CREATED status if created successfully   
	@RequestMapping(value = "/Students", method = RequestMethod.POST)
	public ResponseEntity<Students> addStudent(@RequestBody Students input){
		return new ResponseEntity<>(repository.save(input), HttpStatus.CREATED);
	}

	
	//PUT method which updates a students information. Returns 200 OK status if updated successfully, otherwise 404 not found status if can not find student with ID.
	@RequestMapping(value = "/Students/{id}" , method = RequestMethod.PUT)
	public ResponseEntity updateStudents(@PathVariable Integer id, @RequestBody Students input)
	{
		Students student = repository.findOne(id);
		if(student == null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		student.setFirstName(input.getFirstName()); 
		student.setLastName(input.getLastName()); 
		student.setCourse(input.getCourse());
		student.setEmail(input.getEmail());
		student.setAddress(input.getAddress());
		student.setAge(input.getAge());
		
		return new ResponseEntity<>(repository.save(student), HttpStatus.OK);
	}
	
	//DELETE method which deletes a student with given ID from the repository. Returns 200 OK status if deleted successfully, 404 NOT FOUND if ID is not in the repository.
	@RequestMapping(value = "/Students/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteStudents(@PathVariable Integer id)
	{
		Students student = repository.findOne(id);
		if (student == null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		repository.delete(student);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
