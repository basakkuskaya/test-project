package net.javabasak.springboot_backend_basak.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND) 
public class ResourceNotFoundExeption extends RuntimeException {
	
	
	public ResourceNotFoundExeption(String message) {
		
		super(message);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
