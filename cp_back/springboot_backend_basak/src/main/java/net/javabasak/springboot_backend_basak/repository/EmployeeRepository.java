package net.javabasak.springboot_backend_basak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; //Jparepositoryimplementation class ı için gerekli.

import net.javabasak.springboot_backend_basak.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
//all crud database methods:
	
	
	
	
	
	
	
}
