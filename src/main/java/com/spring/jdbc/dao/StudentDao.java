package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entites.Student;

public interface StudentDao 
{
	public int insert(Student student);
	public int change(Student student);
	public int delete(int sid);
	public Student getStudent(int sid);//for select using row mapping
	public List<Student> getAllStudent();

}
