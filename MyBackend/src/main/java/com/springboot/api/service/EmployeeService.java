package com.springboot.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.api.model.Employee;
import com.springboot.api.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee insertEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public void deleteById(Long id) {
		employeeRepository.deleteById(id);
		
	}

	public Employee findEmployeeById(Long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		if(optional.isPresent()) {
			Employee employee = optional.get();
			return employee; 
		}
		return null;
	}

	public List<Employee> getEmployeesByCity(String city) {	 
		return employeeRepository.findByCity(city);
	}

	public List<Employee> getEmployeesByDepartment(Long did) { 
		return employeeRepository.findByDepartmentId(did);
	}

	public List<Employee> getEmployeesByCityV2(String city) {
		return employeeRepository.getEmployeesByCityV2(city);
	}
	public List<Employee> getEmployeesByDepartmentV2(Long did) { 
		return employeeRepository.findByDepartmentIdV2(did);
	}

}
/*
EmployeeRepository extends JpaRepository<I> : 
save(T):T
findAll() : List<T>
deleteById(id) : void
findById(id) : T
*/