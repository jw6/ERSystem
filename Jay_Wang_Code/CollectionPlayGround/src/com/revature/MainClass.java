package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.revature.pojo.Student;
import com.revature.util.StudentGpaComparator;

public class MainClass {

	/*
	 * 	Collections & Generics are sperate topics
	 * 		but heavily used together
	 *
	 *	Collection = grouping of elements, java's built in data structures
	 *
	 *	Generics<T> - provide compile time data type safety
	 *
	 *	
	 *	Sorting Collections
	 *		- ArrayList.sort()
	 *		- Collections.sort()
	 *		Both use Comparable Interface for natural ordering
	 *			Must implement the comparable Interface to get the natural/default ordering for Custom
	 *		Comparable Interface - gives the compareTo(arg1)
	 *		Comparator: additional/alternate sorting available - unnatural 
	 * 	
	 *	Single Responsibility Principle
	 *		decouple classes		
	 */

	public static void main(String[] args) {
		List<String> myStrings = new ArrayList<String>();
		myStrings.add("steve");
//		myStrings.add(10);
		//must be string becasue the Generic <String> is restricting, allowing 
		
//		setExample();
//		mapExample();
//		arrayListExample();
		collectionOfStudents();
	}
	
	public static void collectionOfStudents() {
		List<Student> students = new ArrayList<>();
		students.add(new Student(1,"jay",4.0));
		students.add(new Student(5, "Tom", 2.5));
		students.add(new Student(2,"John", 3.0));
		students.add(new Student(4,"Kevin", 3.1));
		students.add(new Student(3,"Jim", 3.2));
		
		//How do I sort by the ID's of the students
//		students.sort(null);
		//Default/Natural - the Student Class implements the Comparable INterface to allow sorting
		students.sort(new StudentGpaComparator());
		//Pass in an instance of a Comparator that contains the logic 
		//How do I sort by the gpa
		System.out.println(students);
	}
	
	public static void arrayListExample() {
		List<Integer> myNumbers = new ArrayList<>();
		myNumbers.add(55);
		myNumbers.add(11);
		myNumbers.add(15);
		myNumbers.add(10);
		myNumbers.sort(null);
		
		//Collection with the s at the end, is apart of the Collections framework
		//Userful classes with a bunch of static methods
		Collections.shuffle(myNumbers);		//Older, most interviewers 
		
		for(Integer i : myNumbers) {
			System.out.println(i);
		}
		
	}
	
	
	//toggle block alt + cmd + a
	public static void mapExample() {
		Map<Integer, String> myMap = new HashMap<>();
		myMap.put(1, "Steve");
		myMap.put(2, "Jobs");
		myMap.put(5, "Sam");
		myMap.put(5, "Tim");
		myMap.put(10, "Same");
		
		for(String s : myMap.values()) {
			System.out.println("myMap.Value " + s);
		}
		
		for(Integer i : myMap.keySet()) {
			System.out.println("myMap.keySet " + i);
		}
		
		for(Integer i : myMap.keySet()) {
			System.out.println("myMap.keySet " + i);
			System.out.println("myMap.get() " + myMap.get(i));
		}
		
	}
	
	public static void setExample() {
					//<> - Diamond Syntax, introduced in 1.7
		Set<Integer> hashSet  = new HashSet<>();	//sorted based on hashing, aka rnadom
		
		hashSet.add(5);
		hashSet.add(5);
		hashSet.add(2);
		hashSet.add(17);
		hashSet.add(6);
		
		System.out.println("HashSet: " + hashSet);		// no duplicate
		System.out.println("HashSet size" + hashSet.size());
		
		Set<Integer> treeSet = new TreeSet<>();
		treeSet.addAll(hashSet);
		System.out.println("TreeSet " + treeSet);
		for(Object i : hashSet) {
			System.out.println(i);
		}
		for(Integer i : treeSet) {
			System.out.println(i);
		}
	}
	
	public void rawCollection() {

		List myRawList = new ArrayList();
		myRawList.add("string");
		myRawList.add("steve");
		myRawList.add("John");
		
		for(Object s : myRawList) 
			System.out.println(s);
		
		Iterator ite = myRawList.iterator();
		while(ite.hasNext()) {
			System.out.println(ite.next());
		}
	}
}
