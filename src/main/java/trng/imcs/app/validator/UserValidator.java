package trng.imcs.app.validator;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import trng.imcs.app.model.Employee;



@Component
public class UserValidator implements Validator {
	final static Logger logger = Logger.getLogger(UserValidator.class);
	
	public boolean supports(Class<?> clazz) {
		logger.debug("supports called");
		if (clazz.equals(Employee.class)) {
			return true;
		}
		
		return false;
	}

	public void validate(Employee employee, Errors errors) {
		logger.debug("validate called");
		
		

		ValidationUtils.rejectIfEmpty(errors, "userName", "user.username.empty.err");

		if (! isValidUserName(employee.getFname())) {
			errors.reject("userName", "username.err");
		}		
		
//		if (! isValidEmail(user.getEmail())) {
//			errors.reject("email", "user.email.invalid.err");
//		}
//		
//		if (! isValidPassword(user.getPassword())) {
//			errors.reject("password", "user.password.err");
//		}
//
//
//		if (user.getAnualSalary() < 10000) {
//			errors.reject("anualSalary", "user.anualSalary.err");
//		}
	}

	private boolean isValidPassword(String password) {
		if (StringUtils.isEmpty(password)) {
			return false;
		}
		
		if(password.trim().length() < 8) {
			return false;
		}
		
		
		return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");
	}

	private boolean isValidUserName(String userName) {
		
		if (StringUtils.isEmpty(userName)) {
			return false;
		}
		
		if(userName.trim().length() < 5) {
			return false;
		}
		
		return userName.matches("^[a-zA-Z0-9_]*$");
	}

	private boolean isValidEmail(String email) {
		
		return email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		
	}

}
