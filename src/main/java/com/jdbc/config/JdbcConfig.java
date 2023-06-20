package com.jdbc.config;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoIMPL;
import com.spring.jdbc.entites.Student;

@Configuration
@ComponentScan(basePackages={"com.spring.jdbc.dao"})
public class JdbcConfig
{
	@Bean(name="ds")
	public DataSource getDataSource()
	{
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springpracticejdbc");
		ds.setUsername("root");
		ds.setPassword("");
		return ds;
	}
	
	@Bean(name="jdbcTemplete")
	public JdbcTemplate getTmplete()
	{
		JdbcTemplate jdbcTemplete=new JdbcTemplate();
		jdbcTemplete.setDataSource(getDataSource());
		return jdbcTemplete;
	}
	
	@Bean(name="studentDao")
	public StudentDaoIMPL getStudentdao()
	{
		StudentDaoIMPL studentDao= new StudentDaoIMPL();
		studentDao.setJdbcTemplete(getTmplete());
		return studentDao;
			
	}
	

}
