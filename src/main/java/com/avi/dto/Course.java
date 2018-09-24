package com.avi.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avi.model.sqlserver.Teacher;


@Entity
@Table(name="COURSE")
public class Course {

	private long courseId;
	private String courseName;
	
	private Teacher teacher;

	public Course() {
	}

	public Course(String courseName) {
		this.courseName = courseName;
	}

	@Id
	@GeneratedValue
	@Column(name="COURSE_ID")
	public long getCourseId() {
		return this.courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	@Column(name="COURSE_NAME", nullable=false)
	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	@ManyToOne(fetch=FetchType.LAZY )
	@JoinColumn(name="techer_id")
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher techer) {
		this.teacher = techer;
	}

}
