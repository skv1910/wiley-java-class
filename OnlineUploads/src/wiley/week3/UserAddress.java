package wiley.week3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import java.util.TreeMap;

public class UserAddress {
	
	
	public static void main(String[] args) {
		
		 List<Address1> addrlst = new ArrayList<Address1>();
		 List<User1> usrlst = new ArrayList<User1>();
		
		 Map<Address1, List<User1>> cities = new TreeMap<Address1, List<User1>>(new CitySort());
//		 Map<Address1, List<User1>> cities = new HashMap<Address1, List<User1>>();
		 Map<User1, List<Address1>> users = new HashMap<User1, List<Address1>>();
		 
		//---------------------------------------------------creating users--------------------------------------------------------------------
			usrlst.add(new User1(1, "user1"));
			usrlst.add(new User1(2, "user2"));
			usrlst.add(new User1(3, "user3"));
			usrlst.add(new User1(4, "user4"));
			//---------------------------------------------------creating cities--------------------------------------------------------------------
			addrlst.add(new Address1(110003, "Delhi"));
			addrlst.add(new Address1(600011, "Chennai"));
			addrlst.add(new Address1(400014, "Mumbai"));
			addrlst.add(new Address1(600001, "Chennai"));
			addrlst.add(new Address1(110049, "Delhi"));
			addrlst.add(new Address1(400074, "Mumbai"));
			//-------------------------------------------------Mapping users to cities--------------------------------------------------------------------
			users.put(usrlst.get(0) , addrlst.subList(0, 3));
			users.put(usrlst.get(1) , addrlst.subList(3, 6));
			users.put(usrlst.get(2) , addrlst.subList(1, 3));
			users.put(usrlst.get(3) , addrlst.subList(2, 5));
		
		for (Entry<User1, List<Address1>> entry : users.entrySet()) {
			for(Address1 x: entry.getValue()) 
				if(cities.get(x) == null) 
					cities.get(x).add(entry.getKey());
				
				else {
					List<User1> temp = new ArrayList<User1>();
					temp.add(entry.getKey());
					cities.put(x, temp);
//					System.out.println(cities.get(x));
				}
			
			for (Entry<Address1, List<User1>> entry1 : cities.entrySet()) {
				System.out.println(entry1.toString());
			}
			System.out.println("-------------------------------------------------------------------------------------------------------------");
			
		}
		for (Entry<User1, List<Address1>> entry : users.entrySet()) {
			System.out.println(entry.toString());
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------");
//		for (Entry<Address1, List<User1>> entry : cities.entrySet()) {
//			System.out.println(entry.toString());
//		}
//		System.out.println("-------------------------------------------------------------------------------------------------------------");
		
	}
	
}
class CitySort implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {
		return 1;
		
	}
	
}



