package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jdbc.config.JdbcConfig;
import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entites.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //spring jdbc  -> Jdbctemplete
       //(when we have the config.xml file) ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        /*JdbcTemplate templete=(JdbcTemplate) context.getBean("jdbcTemplete");
      
      
      
      //insert query
       String  query="insert into student(sid, sname, scity) values (? ,? ,?)";        //fire query
       int result = templete.update(query,4,"ShreeVali","New-Mumbai");
       System.out.println("number of value inserted .." +result);*/
       
      //when we delete config.xml it store in javaeclipse folder
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        
       StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
       
       //insert
       /* Student s1=new Student();
        s1.setSid(5);
        s1.setSname("jyoti");
        s1.setScity("Nasik");
        int res=studentDao.insert(s1);
        System.out.println("student added:"+res);*/
        
       
       //update
//        Student s1 = new Student();
//        s1.setSid(5);
//        s1.setSname("niki");
//        s1.setScity("chanda");
//        int res=studentDao.change(s1);
//        System.out.println("student update:"+res);
//        
        //delete
       // int res= studentDao.delete(5);
       // System.out.println("student delete:"+res);
        
       //select using row mapping
      // Student s1= studentDao.getStudent(3);
      // System.out.println("student data.."+s1);
       
       //select multiple data using row mapper
       List<Student> students = studentDao.getAllStudent();
       for(Student s:students)
       {
    	   System.out.println(s);
       }
        
    }
}
