package com.student.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.student.message.ResponseMessage;
import com.student.model.Student;
import com.student.repository.StudentRepo;
import com.student.service.StudentService;


@Path("/studentapi")
public class StudentApi {
	
	@Autowired
	private StudentService studentService;
	 
	 @Path("/createstudent")
	 @POST
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response createStudent(Student student)
	 {
		   if(studentService.createStudent(student) != null)
		   {
			    ResponseMessage message=new ResponseMessage();
			    message.setMessage("student is creatd successfully");
			    message.setHttpCode(201);
			    message.setCode(201);
			    return Response.ok().entity(message).build();
		   }
		    ResponseMessage message=new ResponseMessage();
		    message.setMessage("student is  not creatd successfully");
		    message.setHttpCode(201);
		    message.setCode(201);
		    return Response.ok().entity(message).build();
		  
	 }
	 
	 
	 @Path("/getstudent/{id}")
	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response getStudent(@PathParam("id") Integer id)
	 {
		  Student student=studentService.getStudent(id);
		  if(student != null)
		  {
			   return Response.ok().entity(student).build();
		  }
		   
		  ResponseMessage message=new ResponseMessage();
		  message.setMessage("student is  not found");
		  message.setHttpCode(404);
		  message.setCode(404);
		  return Response.ok().entity(message).build();
	 }

}
