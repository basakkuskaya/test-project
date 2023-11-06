package net.javabasak.springboot_backend_basak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import net.javabasak.springboot_backend_basak.exception.ResourceNotFoundExeption;
import net.javabasak.springboot_backend_basak.model.Employee;
import net.javabasak.springboot_backend_basak.repository.EmployeeRepository;


@CrossOrigin("*") //access to all clients *. tek birini kabul edeceksek 'origins= {"http://localhost:3000/"}'
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping
	public List<Employee> getAllEmployees(){ //
		
		return employeeRepository.findAll();
		
	}
	
	//build create employee REST API
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		
		return employeeRepository.save(employee);
	}
	
	//build get employee by id REST API
	//id ye göre search işlemi gibi.
	
	 @GetMapping("{id}")
	    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
	        Employee employee = employeeRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundExeption("Employee not exist with id:" + id));
	        return ResponseEntity.ok(employee);
	    }
	 
	 //build update employee REST API
	 
	 @PutMapping("{id}")
	// whenever update resources use Putmapping
	    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails) {
		//get the employee object from database and update employee object  
		 //Requestbody-> convert json to Employee object
		 Employee updateEmployee = employeeRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundExeption("Employee not exist with id: " + id));

	        updateEmployee.setFirstName(employeeDetails.getFirstName());
	        updateEmployee.setLastName(employeeDetails.getLastName());
	        updateEmployee.setEmailId(employeeDetails.getEmailId());

	        employeeRepository.save(updateEmployee);

	        return ResponseEntity.ok(updateEmployee);
	    }
	 
	 //build delete employee REST API
	 
	 @DeleteMapping("{id}")
	    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){

	        Employee employee = employeeRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundExeption("Employee not exist with id: " + id));

	        employeeRepository.delete(employee);

	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 //NO_CONTENT, HTTP durum kodlarından biridir ve 204 olarak ifade edilir.
		 //Bu kod, bir HTTP isteğinin başarılı bir şekilde işlendiğini, 
		 //ancak herhangi bir içerik döndürülmediğini belirtir. 
		 //Özellikle bir kaynak silme işlemi başarılı olduysa veya bir kaynak güncelleme işlemi başarılı olduysa sıkça kullanılır.
	 
	 
	 }
	

	    }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	

