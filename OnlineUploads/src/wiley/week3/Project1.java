package wiley.week3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Project1 {
	
	

	public static void main(String[] args) {
		
		List<Address> addr = new ArrayList();
		addr.add(new Address("Chennai", "600011"));
		addr.add(new Address("Chennai", "600089"));
		addr.add(new Address("Mumbai", "400001"));
		addr.add(new Address("Delhi", "110006"));
		
		List<Project> prl = new ArrayList();
		prl.add(new Project(11037, 1000000.0, "JPMC"));
		prl.add(new Project(35001, 800000.0, "Morgan Stanley"));
//		prl.add(new Project(00131, 1500000.0, "Wiley"));
		
		List<User> users = new ArrayList();
		users.add(new Employee("Wil002", "emp1", addr.get(2), prl.get(0), 400000.0));
		users.add(new User("wil001", "User1"));
		users.add(new Employee("Wil003", "emp2", addr.get(0), prl.get(1), 200000.0));
		users.add(new Employee("Wil004", "emp3", addr.get(1), prl.get(0), 500000.0));
		users.add(new User("wil005", "User2"));
		users.add(new Employee("Wil006", "emp4", addr.get(3), prl.get(1), 600000.0));
		users.add(new Employee("Wil007", "emp5", addr.get(1), prl.get(0), 500000.0));
		
		List<Employee> emp_list = getEmployee(users);
		
		validateProject(emp_list, prl.get(0));
		validateProject(emp_list, prl.get(1));
		
		}

	static List<Employee> getEmployee(List<User> u){
		
		List<Employee> e = new ArrayList();
		
		for(User x: u) {
			if(x instanceof Employee)
				e.add((Employee)x);
		}
		return e;
	}
	
	static void validateProject(List<Employee> e, Project p) {
		double cost_incurrent=0;
		
		List<Employee> emp_in = new ArrayList();
		
		for(Employee x: e) {
			if(x.getProject().equals(p)) {

				emp_in.add(x);
				cost_incurrent+=x.getSalary();
			}	
		}
		if(cost_incurrent<=p.getBudjet()) {
			System.out.println("Project: "+ p.getPname() + " is within its budjet");
		}
		
		else {
			Collections.sort(emp_in,new EmpSortBySalary());	
			for(Employee y: emp_in) 
				if(cost_incurrent - y.getSalary() <= p.getBudjet()) {
					System.out.println(y.getId() + " must be removed from project: " + p.getPname());
					break;
				}
			}
	}	
}

class User{
	private String id;
	private String name;
	
	public User(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

class Address{
	private String city;
	private String zipcode;
	
	public Address(String city, String zipcode) {
		this.city = city;
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
}

class Project{
	int projectid;
	double budjet;
	String pname;
	
	public Project(int projectid, double budjet, String name) {
		super();
		this.projectid = projectid;
		this.budjet = budjet;
		this.pname = name;
	}
	public int getProjectid() {
		return projectid;
	}
	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}
	public double getBudjet() {
		return budjet;
	}
	public void setBudjet(double budjet) {
		this.budjet = budjet;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String name) {
		this.pname = name;
	}	
}

class Employee extends User{
	Address address;
	Project project;
	Double salary;
	
	public Employee(String id, String name, Address address, Project project, Double salary) {
		super(id, name);
		this.address = address;
		this.project = project;
		this.salary = salary;
	}
	public Address getAddress() {
		return address;
	}
	public Project getProject() {
		return project;
	}
	public Double getSalary() {
		return salary;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
}

class EmpSortBySalary implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Employee emp1 = (Employee)o1;
        Employee emp2 = (Employee)o2;

        if(emp1.getSalary() > emp2.getSalary())
        	return 1;
        else if(emp1.getSalary() < emp2.getSalary())
        	return -1;
        else
        	return 0;
    }
}

