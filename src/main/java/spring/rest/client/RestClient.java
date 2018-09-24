package spring.rest.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.avi.model.sqlserver.User;

public class RestClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		 final RestTemplate restTemplate = new RestTemplate();
		 User user = new User();
		 user.setAge(30);
		 user.setId(3);
		 user.setName("ashish");
		 		 
		 ResponseEntity<User[]> responseEntity = restTemplate.getForEntity("http://localhost:9090/student-portal/user/", User[].class);
		 User[] userArr = responseEntity.getBody();
		 MediaType contentType = responseEntity.getHeaders().getContentType();
		 HttpStatus statusCode = responseEntity.getStatusCode();
		
		Arrays.stream(userArr).map(usr ->usr.getName()).forEach(System.out::print);
		// restTemplate.postForObject(url, request, responseType, uriVariables);

		 
		// ResponseEntity<User[]> responseEntity =restTemplate.getForObject("http://localhost:9090/student-portal/user" ,ResponseEntity.class );

	}

}
