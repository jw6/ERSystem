package com.revature.util;

import java.util.Comparator;

import com.revature.pojo.Student;

public class StudentGpaComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {

		if (o1.getGpa() > o2.getGpa()) {
			return 1;
		} else if (o1.getGpa() == o2.getGpa()) {
			return 0;
		}

		else {
			return -1;
		}

	}

}
