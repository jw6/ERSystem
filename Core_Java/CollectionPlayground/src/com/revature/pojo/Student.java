package com.revature.pojo;
//pojo
public class Student implements Comparable<Student> {

	//state
	private int id;
	private String name;
	private double gpa;
	
	//no-args
	public Student(){}
	
	public Student(int id, String name, double gpa) {
		super();
		this.id = id;
		this.name = name;
		this.gpa = gpa;
	}



	//behavior

	public int getId() {
		return id;
	}

	public void setId(int id) {
		//id is for the method
		//this.id is for the instance
		//id is shadowing the this.id 
		this.id = id;
		if(true){
			String x;
//			System.out.println(x); //Note Local Variables do not get a default value
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
	
	//toString
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gpa=" + gpa + "]";
	}

	@Override
	public int compareTo(Student o) {
		return this.id - o.id; //positive, 0, negative to determine the order
	}

	
}
