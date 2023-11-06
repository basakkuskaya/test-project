package net.javabasak.springboot_backend_basak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javabasak.springboot_backend_basak.model.Employee;
import net.javabasak.springboot_backend_basak.repository.EmployeeRepository;

@SpringBootApplication
public class SpringbootBackendBasakApplication implements CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendBasakApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
	//	Employee employee = new Employee();
	//    employee.setFirstName("Ramesh");
	//	employee.setLastName("Fedarate");
	//	employee.setEmailId("ramesh@gmail.com");
	//	employeeRepository.save(employee);
		
	//	Employee employee1 = new Employee();
	//	employee1.setFirstName("John");
	//	employee1.setLastName("Cena");
	//	employee1.setEmailId("cena@gmail.com");
	//	employeeRepository.save(employee1);
		
	} 
	
	

}
