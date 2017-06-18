package trng.imcs.app.repositories;

import java.io.IOException;

import trng.imcs.app.model.Employee;

public class EmployeeDBImpl implements EmployeeDBInterface {
	//DBQueryExecution queryExecution = new DBQueryExecution();
	EmployeeDao empDao = new EmployeeDao();
	Employee emp = new Employee();
	@Override
	public Employee getEmployeeInfo(int empNo) {
		try {
			return empDao.getEmployee(empNo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}
	@Override
	public boolean addEmployeeInfo(Employee employee) {
		boolean flag = false;
		try {
			flag = empDao.setEmployee(employee);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
	}

}
