package com.revature.beans;

import java.io.Serializable;

/*
 *  JavaBean: another more stricts version of a POJO
 *  		1. State must be fully Encapsulated
 *  		2. Must have no-args Constructor
 *  		3. Overriden toString
 *  		4. Implements Serializable
 *  
 *  Serialization Interface - a Marker Interface, an Interface with no methods that tells 
 *  		the JVM something special allowing the class to be Serialized by default all 
 *  		Objects are Blacklisted, must Whitelist them
 *  		- Read from a file that has an Exception written to it will cause
 *  			java.io.WrtieAbortedException
 *  
 *  Serialization Steps
 *  		1. Our Object must implement Serializable - avoid hava.io.NotSerializableException
 *  		2. Add serialVersionUID - must match for deserialization to avoid java.io.InvalidClassException:
 *   	3. Use ObjectInputStream/ObjectOutputStream and pass the object
 *   			-deserialization will be give the default value of the data type
 *   	4. Use ObjectImputeStream/ObjectOutputStream and pass the object
 */




public class Student implements Serializable {
	//state
	
	/**
	 *  For deserialization, match the version or we are out of date
	 */
	private static final long serialVersionUID = 193209348L;
	
	private int id;
	private String name;
	private transient int ssn;
	
	public Student(int id, String name, int ssn) {
		super();
		this.id = id;
		this.name = name;
		this.ssn = ssn;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	//NO-ARGS
	public Student() {
		
	}
	
	//behaviors
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", ssn=" + ssn + "]";
	}
	
	
	
}
