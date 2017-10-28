package com.example.mastercard.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Random;


@Entity
public class Students {
	@Id
	@GeneratedValue
	private int id;
    private String firstName;
	private String lastName;
	private String email;
	private String course;
	private String address;
	private int age;
	
	//Default constructor 
	public Students(){
		
	}
	
	//class constructor
	public Students(String firstName, String lastName, String email, String course, String address, int age)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.course = course;
		this.email = email;
		this.address = address;
		this.age = age;
	}	

	public int getID()
	{
		return id;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getCourse()
	{
		return course;
	}

	public String getEmail()
	{
		return email;
	}
	
	public String getAddress()
	{
		return address;
	}

	public int getAge()
	{
		return age;
	}
	
	public String setFirstName(String newFirstName)
	{
		return this.firstName = newFirstName;
	}
	
	public String setLastName(String newLastName)
	{
		return this.lastName = newLastName;
	}
	
	public String setCourse(String newCourse)
	{
		return this.course = newCourse;
	}

	public String setEmail(String newEmail)
	{
		return this.email = newEmail;
	}
	
	public String setAddress(String newAddress)
	{
		return this.address = newAddress;
	}

	public int setAge(int newAge)
	{
		return this.age = newAge;
	}	
	
	//Generates a random email based on first and last name
	public String generateEmail(String fname, String lname)
	{
		
		Random random = new Random();
		int num1 = random.nextInt(9);
		int num2 = random.nextInt(9);
		int num3 = random.nextInt(9);
		StringBuilder number = new StringBuilder();
		number.append(num1 + "" + num2 + ""+ num3);
		String email = new String(fname.substring(0,1) + lname + number + "@tcd.ie");
		return email;
	}
	
	//Generates a random course from a list of courses 
	public String generateCourse()
	{
		String[] courseArray = {"Computer Science", "Arts", "English", "Physiotherapy", "Engineering", "Medicine", "Nursing", "Business", "Dentistry", "Pharmacy"};
		Random random = new Random();
		int randomNum = random.nextInt(9);
		return courseArray[randomNum];
	}

	
}


