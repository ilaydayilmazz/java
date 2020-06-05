package com.i.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.i.domain.Employee;

@RestController
@RequestMapping("/emp")
public class EmployeeRestController {
	//1
	/*static List<Employee> employees= new ArrayList<Employee>();
	static {
		employees.add(new Employee ("hermione","granger"));
		employees.add(new Employee ("ron","weasley"));
		employees.add(new Employee ("harry","potter"));
		employees.add(new Employee ("jk","rowling"));
		
	}*/
	//2
	List<Employee> employees;
	//bean olusturunca
	@PostConstruct
	public void loadData() {
		employees= new ArrayList<Employee>();
		employees.add(new Employee ("hermione","granger"));
		employees.add(new Employee ("ron","weasley"));
		employees.add(new Employee ("harry","potter"));
		employees.add(new Employee ("jk","rowling"));
		
	}
	
	
	@GetMapping("/mrb")
	public String merhaba() {
		return "merhaba";
	}
	
	@GetMapping("/emp")
	public Employee emp() {
		Employee mgr= new Employee("Ada","Can");
		Employee emp=  new Employee("mehmet","ada");
		//return new Employee("ilayda","yilmaz");
		emp.setManager(mgr);
		return emp;
	}
	
	@GetMapping("/emps")
	public List<Employee> emps() {
		List<Employee> empList=new ArrayList<Employee>();
		Employee mgr= new Employee("a","b");
		Employee emp= new Employee("c","d");
		emp.setManager(mgr);
		empList.add(emp);
		empList.add(mgr);
		empList.add(new Employee("e","f"));
		return empList;
		
	}
	@GetMapping("/emps/{indeks}")
	public Employee getEmp(@PathVariable int indeks) {
		if(indeks>=employees.size()|| indeks<0)
			throw new EmployeeNotFoundException("Boyle bir emp id mevcut degil: "+indeks);
			//return new Employee("asd","sdfg");
		if(indeks==2)
		throw new RuntimeException("olamaz oyle hata");
	return employees.get(indeks);
		
	}
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> hataYakala(EmployeeNotFoundException exc){
		EmployeeErrorResponse hata=new EmployeeErrorResponse();
		hata.setStatus(HttpStatus.NOT_FOUND.value());
		hata.setMessage(exc.getMessage());
		return new ResponseEntity<>(hata,HttpStatus.NOT_FOUND);
	}
	

	
	
}
