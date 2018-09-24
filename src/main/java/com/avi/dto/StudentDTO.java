package com.avi.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StudentDTO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long studentId;
	private String studentName;
	private Set<Course> courses = new HashSet<Course>(0);

	public StudentDTO() {
	}

	public StudentDTO(String studentName) {
		this.studentName = studentName;
	}

	public StudentDTO(String studentName, Set<Course> courses) {
		this.studentName = studentName;
		this.courses = courses;
	}


	public long getStudentId() {
		return this.studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	
	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	
	public Set<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "StudentDTO [studentId=" + studentId + ", studentName=" + studentName+" ]";
	}

}
