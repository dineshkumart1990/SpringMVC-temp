package trng.imcs.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import trng.imcs.app.model.Employee;
import trng.imcs.app.services.EmployeeOperations;
import trng.imcs.app.validator.UserValidator;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeOperations operations;

	@Autowired
	private UserValidator userValidator;
	
	@InitBinder
	protected void InitBinder(WebDataBinder Binder){
		Binder.addValidators(userValidator);
	}
	
	@RequestMapping("/employeeSearch")
	public String searchEmployee(@RequestParam("number") Integer empNo, Model model){
		Employee emp = operations.getEmployee(empNo);
		System.out.println(emp.getFname());
		model.addAttribute("Employee", emp);
		return "searchMsg";
	}
	
	
	@RequestMapping(value="/addEmployee", method=RequestMethod.POST)
	public String redirectSearchHtml(@ModelAttribute @Valid Employee emp, Model model, BindingResult result){
		boolean status = operations.addEmployee(emp);
		if (status==true){
			model.addAttribute("Message", "Employee  "+emp.getFname()+" "+emp.getLname()+"  added successfully");
		}else if (status==false){
			model.addAttribute("Message", "Employee  "+emp.getFname()+" "+emp.getLname()+"  adding failed");
		}
		//model.addAttribute("Employee", emp);
		return "InsertemployeeInfo";
	}

}
