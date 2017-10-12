package com.revature.beans;

import java.io.Serializable;

/*
 * 	JavaBean: another more strict version of a POJO
 * 		1. State must be fully Encapsulated
 * 		2. Must have no-args Constructor
 * 		3. Overriden toString
 * 		4. implements Serializable 
 * 	
 * 	Serializable Interface - a Marker Interface, an Interface with no methods that tells the JVM something special.
 * 		In the case of the Marker Interface Serializable "the something special" is allowing the class to be Serialized
 * 			by default all Objects are Blacklisted, must Whitelist them
 * 		-Read from a file that has an Exception written to it will cause
 * 			java.io.WriteAbortedException
 * 
 * 	Serialization Steps:
 * 		1. Our Object must implements Serializable - avoids java.io.NotSerializableException
 * 		2. Add serialVersionUID - must match for deserialization to avoid java.io.InvalidClassException
 * 		3. Add transient keyword to any state that is sensitive, will be ignore from Serialization
 * 				-deserialization will be give the default value of the datatype
 * 		4. Use ObjectInputStream/ObjectOutputStream and pass the object
 */
public class Student implements Serializable{

	/**
	 *  For deserialization, match the version or we are out of date
	 */
	private static final long serialVersionUID = 1961906105668830657L;
	
	//state
	private int id;
	private String name;
	private transient int ssn;
	
	//NO-ARGS
	public Student() {	}
	
	public Student(int id, String name, int ssn) {
		super();
		this.id = id;
		this.name = name;
		this.ssn = ssn;
	}



	//Behavior
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


	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", ssn=" + ssn + "]";
	}
	
	
}
