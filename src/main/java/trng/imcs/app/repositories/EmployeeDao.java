package trng.imcs.app.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import trng.imcs.app.model.Employee;
import trng.imcs.app.util.EmployeeUtil;

public class EmployeeDao {

	//JDBCConnectionFactory connection = new JDBCConnectionFactory();
	
	ResultSet rs = null;
	Connection conn;
	
	public Employee getEmployee(int empId) throws IOException {
		Employee employee = new Employee();
		//employee = null;
		//conn = connection.getConnection();
		Connection conn = JDBCConnectionFactory.getConnection();
		System.out.println(conn);
		try(PreparedStatement pStatement = conn.prepareStatement("SELECT * FROM employee WHERE emp_no= ?")){

			pStatement.setInt(1, empId);
			rs = pStatement.executeQuery();

			while (rs.next()) {
				employee.setNumber(rs.getInt("emp_no"));
				employee.setFname(rs.getString("first_name"));
				employee.setLname(rs.getString("last_name"));
				employee.setDob(rs.getString("birth_date"));
				employee.setDoj(rs.getString("hire_date"));
				//employee.setDob(rs.getDate("birth_date"));
				//employee.setDoj(rs.getDate("hire_date"));
				
				employee.setGender(rs.getString("gender"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employee;

	}

	public boolean setEmployee(Employee employee) throws IOException {
		boolean flag = false;
		Employee emp1 = null;
		emp1 = getEmployee(employee.getNumber());
		//if (emp1==null){
		Connection conn = JDBCConnectionFactory.getConnection();
		System.out.println(conn);
		try(PreparedStatement pStatement = conn.prepareStatement("INSERT INTO employee (emp_no,birth_date,first_name,last_name,gender,hire_date) VALUES (?,?,?,?,?,?)")){
	    	 
	    	  //pStatement = conn.prepareStatement("INSERT INTO employees (emp_no,birth_date,first_name,last_name,gender,hire_date) VALUES (?,?,?,?,?,?)");
	    	  pStatement.setInt(1, employee.getNumber());
	    	  pStatement.setString(2,employee.getDob());
	    	  //pStatement.setDate(2,EmployeeUtil.convertToSqlDate(employee.getDob()));
	    	  pStatement.setString(3, employee.getFname());
	    	  pStatement.setString(4, employee.getLname());
	    	  pStatement.setString(5, employee.getGender());
	    	  //pStatement.setDate(6,EmployeeUtil.convertToSqlDate(employee.getDoj()));
	    	  pStatement.setString(6,employee.getDoj());
			  
	    	  int insCount = pStatement.executeUpdate();
	    	  flag = true;
			  System.out.println("Inserted "+insCount+" records into the table...");
	      }catch(SQLException se){
	    	  se.printStackTrace();
	      }finally {
	    	  try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
		}
	      }

	      //}
		// Update logic for below
		//else if(emp1!=null){
	    //	  flag = updateEmployee(employee);
	     // }
		return flag;
	}
	
	public boolean updateEmployee(Employee employee) throws IOException {
		boolean flag = false;
		Connection conn = JDBCConnectionFactory.getConnection();
		System.out.println(conn);
	//	conn = connection.createConnection();
		System.out.println(conn);
		try(PreparedStatement pStatement = conn.prepareStatement("UPDATE employee SET birth_date=?,first_name=?,last_name=?,gender=?,hire_date=? WHERE emp_no=?")){
			
	    	  //pStatement = conn.prepareStatement("UPDATE employees SET birth_date=?,first_name=?,last_name=?,gender=?,hire_date=? WHERE emp_no=?");
	    	  pStatement.setInt(6, employee.getNumber());
	    	  pStatement.setString(1,employee.getDob());
	    	  //pStatement.setDate(1,EmployeeUtil.convertToSqlDate(employee.getDob()));
	    	  pStatement.setString(2, employee.getFname());
	    	  pStatement.setString(3, employee.getLname());
	    	  pStatement.setString(4, employee.getGender());
	    	  //pStatement.setDate(5,EmployeeUtil.convertToSqlDate(employee.getDoj()));
	    	  pStatement.setString(5,employee.getDoj());
			  
	    	  int upCount = pStatement.executeUpdate();
	    	  flag = true;
			  System.out.println("Updated "+upCount+" records into the table...");
	      }catch(SQLException se){
	    	  se.printStackTrace();
	      }finally {
	    	  try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
		}
	      }
		return flag;
	}

	public boolean deleteEmployee(int empId) {
		boolean flag = false;
		try(Connection conn = JDBCConnectionFactory.getConnection(); 
				PreparedStatement pStatement = conn.prepareStatement("DELETE FROM employee WHERE emp_no=?")){
	    	 
	    	  //pStatement = conn.prepareStatement("DELETE FROM employees WHERE emp_no=?");
	    	  pStatement.setInt(1, empId);
			 
	    	int delCount = pStatement.executeUpdate();
	      System.out.println("Deleted "+delCount+" records into the table...");
	      flag = true;
	      }catch(SQLException se){
	    	  se.printStackTrace();
	      }finally {
	    	  try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
		}

	}
		return flag;
	}
	
}
