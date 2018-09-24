package com.avi.model.sqlserver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

@Entity
@Table(name="teacher")
public class Teacher implements Serializable {
	
	Integer id;
	String name;
		
	Teacher(){}	
	
	Teacher(String name){				
		this.name =name;		
	}
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="student_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	

}
