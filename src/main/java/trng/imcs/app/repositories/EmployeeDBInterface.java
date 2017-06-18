package trng.imcs.app.repositories;

import trng.imcs.app.model.Employee;

public interface EmployeeDBInterface {

	Employee getEmployeeInfo(int empNo);
	boolean addEmployeeInfo(Employee employee);
}
