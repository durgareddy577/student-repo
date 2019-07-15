package com.student.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.model.Student;

@Repository
public class StudentRepo {
	
	  @Autowired
	  private SessionFactory sessionFactory;
	  
	  public Integer createStudent(Student student)
	  {
		     Session session=null;
		     Integer key=0;
		     try {
		    	   session=sessionFactory.openSession();
		    	   session.beginTransaction();
		    	   key=(Integer)session.save(student);
		    	   session.getTransaction().commit();
		     }
		     catch (Exception e) {
				e.printStackTrace();
			}
		     
		   return key;
	  }
	  
	  public Student getStudent(Integer id)
	  {
		    Session session=null;
		    Student student=null;
		    try {
		    	
		    	session =sessionFactory.openSession();
		    	student=session.get(Student.class, id);
		    	return student;
		    }
		    catch (Exception e) {
		    	e.printStackTrace();
			}
		    return student;
	  }

}
