package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entites.Student;

@Component("studentDao")
public class StudentDaoIMPL  implements StudentDao
{
	
	//either
	@Autowired
	private JdbcTemplate jdbcTemplete;
	
	public JdbcTemplate getJdbcTemplete() {
		return jdbcTemplete;
	}

	//or
	//@Autowired
    public void setJdbcTemplete(JdbcTemplate jdbcTemplete) {
		this.jdbcTemplete = jdbcTemplete;
	}



	public int insert(Student student) 
    {
		//insert query
        String  query="insert into student(sid, sname, scity) values (? ,? ,?)";
        int res = this.jdbcTemplete.update(query,student.getSid(),student.getSname(),student.getScity());
		return res;
	}

	public int change(Student student) {
		//update
		String query="update student set sname=?, scity=? where sid=?";
		int r = this.jdbcTemplete.update(query,student.getSname(),student.getScity(),student.getSid());
		return r;
	}

	

	public int delete(int sid) {
		// delete
				String query = "Delete from student where sid=?";
				int r= this.jdbcTemplete.update(query,sid);
				return r;
	}

	public Student getStudent(int sid) {
		// select single data
		String query="select * from student where sid=?";
		//when we create row mapper class
		//RowMapper<Student> rowMapper=new RowMapperimpl();
		//Student student=this.jdbcTemplete.queryForObject(query, rowMapper,sid);
		
		//when we delete row maper class using annonomus class ,using this implementation we have to write code more instead of this use rowmapper class 
		Student student=this.jdbcTemplete.queryForObject(query,new RowMapper(){

			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				student.setSid(rs.getInt(1));
				student.setSname(rs.getString(2));
				student.setScity(rs.getString(3));
				return student;
			}
			
		},sid);
		return student;
	}

	public List<Student> getAllStudent() {
		// select multiple student
		String query="select * from student";
		List<Student>student=this.jdbcTemplete.query(query,new RowMapperimpl());
		return student;
	}

}
