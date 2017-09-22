package com.revature.pojo;

public class Student implements Comparable<Student> {
	//state 
	private int id;
	private String name;
	private double gpa;
	
	//no-args
	public Student() {
		
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gpa=" + gpa + "]";
	}

	public Student(int id, String name, double gpa) {
		super();
		this.id = id;
		this.name = name;
		this.gpa = gpa;
	}

	//behaviors
	public int getId() {
		return id;
	}

	public void setId(int id) {
		//id is for the method
		//this.id is for the instance
		//id is shadowing the this.id
		this.id = id;
		if(true) {
			int x;
			//local variable don't have default value
//			System.out.println(x);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.id - o.id; // positive, 0, negative to determine
	}
	
}
