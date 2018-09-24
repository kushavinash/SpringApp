package com.avi.controller;

import java.util.List;
import java.util.concurrent.Future;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.ui.ModelMap;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;
import com.avi.jms.Sender;
import com.avi.model.sqlserver.Student;
import com.avi.model.sqlserver.User;
import com.avi.service.StudentService;
import com.avi.service.UserService;
import com.avi.utils.NoDataFoundException;


@RestController
@RequestMapping(value="/student")
public class StudentController {
	
	@Autowired
	StudentService studentService ;
	
	@Autowired
	Sender queuesender;

	@Autowired
	UserService userService; 
	
	
	
	 @RequestMapping(value="/home", method = RequestMethod.GET)
	    public ModelAndView showLoginPage(){
	        return new ModelAndView("home");
	    }
	
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)	
	public List<Student> getStudentDetail(@PathVariable(value ="id" )@NotNull(message="id should not be null") @Pattern(regexp = "^[A-Za-z0-9]*$",message="Only alpha numeric id")Long id ,HttpServletRequest
			request,HttpServletResponse response) throws NoDataFoundException{
		List<Student> student=null ;
		HttpSession sess=null;
		try {
			
			sess = request.getSession(true);
			
			student =studentService.getStudent(id);
			
			queuesender.send("",student.get(0).getStudentName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Cookie cookie = new Cookie("avinash","9899720488");
		response.addCookie(cookie);
		System.out.println("getting student details for session id->"+sess.getId());
	 return student;	
	}
	
	

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = userService.findAllUsers();
		if(users.isEmpty()){
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/user2", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> listAllStudentss() {
		List<Student> studentlist =null;
		try {
			studentlist = studentService.getStudentALl();
			if(studentlist.isEmpty()){
				return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<List<Student>>(studentlist, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/save" ,method=RequestMethod.POST)
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		Student sd =null;
		
	  try {
		sd =studentService.saveStudent(student);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return new ResponseEntity<Student>(sd, HttpStatus.OK);	
	}
	
	
	
	
	@Async
	@RequestMapping(value = "/userasync", method = RequestMethod.GET)
	public Future<String> listUsers() {
		List<User> users = userService.findAllUsers();
		if(users.isEmpty()){
			System.out.println("user empty");
			return new AsyncResult<String>("failure message");//You many decide to return HttpStatus.NOT_FOUND
		}
		
		try {
			Thread.sleep(200);
			System.out.println("going to return msg......");
			return new AsyncResult<String>("success message");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("user not empty");
		return new AsyncResult<String>("success message");
	}
	
		
	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<NoDataFoundException> exceptionHandler(Exception ex) {
		NoDataFoundException error = new NoDataFoundException(ex.getMessage());
		error.setId(HttpStatus.PRECONDITION_FAILED.value());
		error.setErroDescription(ex.getMessage());
		return new ResponseEntity<NoDataFoundException>(error, HttpStatus.OK);
	}
	
	/* @ExceptionHandler(NoDataFoundException.class)
	 
	     public ResponseEntity<NoDataFoundException> exceptionHandler(Exception ex) {
	
		 NoDataFoundException error = new NoDataFoundException("no data found");
	
	         error.setId(HttpStatus.PRECONDITION_FAILED.value());
	
	         error.setErroDescription(ex.getMessage());
	
	         return new ResponseEntity<NoDataFoundException>(error, HttpStatus.NO_CONTENT);
	
	     }
	*/

}
