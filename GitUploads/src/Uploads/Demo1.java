package Uploads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Demo1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Emp> list= new ArrayList<>();
		
		list.add(new Emp(1000,"BOM","E1"));
		list.add(new Emp(1200,"DEL","E2"));
		list.add(new Emp(1000,"BLR","E3"));
		
		Collections.sort(list,new userSort());
		
		for(Object x: list) {
			Emp e=(Emp)x;
			e.disp();
		}
	}

}

class Emp{
	int salary;
	String city,name;
	
	Emp(int salary, String city, String name){
		this.salary = salary;
		this.city  =city;
		this.name = name;
	}
	
	void disp() {
		System.out.println(name+" -- "+city+" -- "+salary);
	}

}

class userSort implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Emp e1 = (Emp) o1;
		Emp e2 = (Emp) o2;
		if(e1.salary != e2.salary ) 
			return e1.salary - e2.salary;
		else
			return e1.city.compareTo(e2.city);
	}
	
}

