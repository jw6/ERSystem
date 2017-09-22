package com.revature.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainClass {
	/*
	 * 
	 * FileWriter/FileReader: write/read 1 character at a time
	 * 
	 * BufferedWriter/BufferedReader: write/read 1 Line at a time
	 * 
	 * 
	 */
	

	public static void main(String[] args) {
		String filePath = "src/com/revature/fileio/charExample.txt";
	
//		writeCharacters(filePath);
//		readCharacters(filePath);
		
//		bufferedWriterExample(filePath);
		bufferedReaderExample(filePath);
	}
	
	public static void readCharacters(String filePath){
		//Open a file - FileReader: we are working with Characters
		try (FileReader fr = new FileReader(filePath);){
			int i;
			while( (i = fr.read()) != -1){
				System.out.println( (char)i );
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeCharacters(String filePath){
		//Open a file - FileWriter: we are working with Characters
		try (FileWriter fw = new FileWriter(filePath);) {
			/*
			 * try() - try w/ resources will automatically close connections
			 * 		Allows anything that that is AutoClosable
			 */
			for(int i = 65; i < 72; i++){
				fw.write(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void bufferedWriterExample(String filePath){
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));) {
			writer.write("hello World\n");
			writer.write("BufferedWriter is a lot easier and faster to use!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void bufferedReaderExample(String filePath){
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath));) {
			String line = "";
			while( (line = reader.readLine() ) != null ){
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
