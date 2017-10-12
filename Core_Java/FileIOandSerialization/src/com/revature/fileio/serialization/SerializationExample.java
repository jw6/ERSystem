package com.revature.fileio.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.beans.Student;

public class SerializationExample {
	/* 
	 *  Serialization: Flattening a Java Object to bytes, the state of the object is written to the file
	 *  Deserialization: bytes back into a Java Object
	 */
	public static void main(String[] args) {
		String filePath = "src/com/revature/fileio/serialization/objectExample.txt";
//		new SerializationExample().objectToFile(filePath);
		readObjectFromFile(filePath);
	}
	
	public void objectToFile(String filePath){
		
		try (ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream(filePath) ); ){
			Student s = new Student(1, "steve", 555);
			oos.writeObject(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readObjectFromFile(String filePath){
		try (ObjectInputStream ois = new ObjectInputStream( new FileInputStream(filePath));) {
			
//			Object obj = ois.readObject(); //deserialization
			Student obj = (Student) ois.readObject();  //Downcast to Student
			System.out.println(obj);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
