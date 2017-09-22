package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import com.revature.pojo.Student;
import com.revature.util.StudentGpaComparator;

public class MainClass {
	
	/*
	 * 		Collections & Generics are Separate Topics
	 * 			but heavily used together
	 * 
	 * 
	 * 		Collection - grouping of elements, java's built in data structures
	 * 
	 *  	Generics <T> - provide compile time datatype safety
	 *  
	 *  	Sorting Collections
	 *  		-ArrayList.sort()
	 *  		-Collections.sort()
	 *  		Both use Comparable Interface for natural/default ordering
	 *  			Must implement the Comparable Interface to get the natural/default ordering for Custom Objects
	 * 			
	 * 			Comparable Interface - gives the compareTo(arg1)
	 * 		 	Comparator: additional/alternate sorting available - unnatural  - gives the compare(arg1, arg2)
	 * 
	 * 		Single Responsibility Principle 
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
//		List<String> myStrings = new ArrayList<String>();
//		myStrings.add("steve");
//		myStrings.add(10); 
			//must be string because the Generic <String> is restricting, allowing us to ensure at compile time the right datatype
		
//		setExample();
//		mapExample();
//		arrayListExample();
		collectionOfStudents();
	}
	
	public static void collectionOfStudents(){
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "Steve", 4.0));
		students.add(new Student(5, "Tom", 2.5));
		students.add(new Student(4, "John", 3.0));
		students.add(new Student(3, "Mary", 3.5));
		
		//How do I sort by the ID's of the students?
//		students.sort(null);//Default/Natural -the Student Class implements the Comparable Interface to allow sorting
		
		//How do I also sort by the GPAs or anything other use case?
		students.sort(new StudentGpaComparator()); //Past in an instance of a Comparator that contains the logic needed
		
		System.out.println(students);
	}
	
	
	public static void arrayListExample(){
		List<Integer> myNumbers = new ArrayList<>();
		myNumbers.add(55);
		myNumbers.add(5);
		myNumbers.add(15);
		myNumbers.add(10);
//		myNumbers.sort(null); //new in 1.8, better optimized 
		
		//Collections with the s at the end, is apart of the Collection Framework
			//Useful Class with a bunch of static methods
		Collections.sort(myNumbers);//Older, most interviewers are looking for this
		
		System.out.println(myNumbers);
	}
	
	public static void mapExample(){
		//Maps - Key/Value 
		Map<Integer, String> myMap = new HashMap<>();
		myMap.put(1, "Steve");
		myMap.put(2, "john");
		myMap.put(17, "Mark Z");
		myMap.put(5, "Tom M");
		myMap.put(10, "Courtney");
		myMap.put(10, "Katie");
		myMap.put(12, "Courtney");
		
		System.out.println("HashMap: " + myMap);
		System.out.println("HashMap size: " + myMap.size());
		System.out.println("HashMap single element: " + myMap.get(5));
		System.out.println("HashMap single element: " + myMap.get(99));
		
		//How do we iterate over a map?
		for(String s : myMap.values() ){
			System.out.println("myMap.values()=" + s);
		}
		System.out.println();
		for(Integer i : myMap.keySet() ){
			System.out.println("myMap.keySet()=" + i);
			System.out.println(myMap.get(i));
		}
		System.out.println();
		for(Entry<Integer, String> i : myMap.entrySet() ){
			System.out.println("myMap.entrySet() -key: " + i.getKey() + " value: " + i.getValue());
		}
	}
	
	public static void setExample(){
										//<> - Diamond Syntax ,introduced in 1.7
		Set<Integer> hashSet = new HashSet<>(); //sorted based on hashing, aka random
		hashSet.add(5);
		hashSet.add(5);
		hashSet.add(2);
		hashSet.add(17);
		hashSet.add(6);
		
		System.out.println("HashSet: " + hashSet);
		System.out.println("HashSet Size: " + hashSet.size());
		
		
		Set<Integer> treeSet = new TreeSet<>(); //sorted on the value
		treeSet.addAll(hashSet);
		
		System.out.println("TreeSet: " + treeSet);
		for( Integer i : treeSet){
			System.out.println(i);
		}
	}

	
	public void rawCollection(){
		List myRawList = new ArrayList();
		myRawList.add("string");
		myRawList.add("steve");
		myRawList.add(10);
		
		List myNumbers = new ArrayList();
		myNumbers.add("10");
		
		System.out.println(myRawList);
		
		//EnhancedFor Loop
		for(Object s : myRawList){
			System.out.println(s);
		}
		
		
		Iterator it = myRawList.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
