package trng.imcs.app.services;

import org.springframework.stereotype.Service;

import trng.imcs.app.model.Employee;
import trng.imcs.app.repositories.EmployeeDBImpl;
import trng.imcs.app.repositories.EmployeeDBInterface;

@Service
public class EmployeeOperations {
	
	EmployeeDBInterface dbImpl = new EmployeeDBImpl();
	
	public Employee getEmployee(int empNo){
		return dbImpl.getEmployeeInfo(empNo);
	}
	
	public boolean addEmployee(Employee employee){
		return dbImpl.addEmployeeInfo(employee);
	}
}
