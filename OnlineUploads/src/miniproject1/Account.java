package miniproject1;

import java.util.ArrayList;
import java.util.HashMap;

public class Account extends Customer{
	
	static String[] acc_types = {"saving","current"};
	static HashMap<String, Double> min_balance = new HashMap<String, Double>();
	{
	min_balance.put(acc_types[0],1000.0); 	// acc code : 1
	min_balance.put(acc_types[1], 0.0);		// acc code : 2 
	}

	double balance;
	String acc_type;
	String acc_no;
	ArrayList<String> transactions;
	private String password ="1234";
	
	public Account(int acc_type_code, String acc_no,double balance,Customer c) {	
		
		super(c);
		this.acc_type = acc_types[acc_type_code-1];
		this.acc_no = acc_no;
		this.balance = balance;
		this.transactions = new ArrayList<String>();	
	}

	public Account(String name, String mail, String aadhar, String pan, String phone, double balance, int acc_code,
			String acc_no) {
		super(name, mail, aadhar, pan, phone);
		this.balance = balance;
		this.acc_type = acc_types[acc_code];
		this.acc_no = acc_no;
		this.transactions = new ArrayList<String>();
	}


	protected double getBalance() {
		return balance;
	}
	
	protected String debit(double amount) {
		
		if(balance - amount >= 0) {
			
			balance-=amount;
			transactions.add(transactions.size() +1 + " --> " + amount+ " debited from account; Balance: "+balance);
			
			if( balance < min_balance.get(acc_type) ) 
				return "Transaction Successful \n\"ALERT\\\" Balance less than minimun balance" ;
			else
				return "Transaction Successful";
		}
		
		else {
			transactions.add(transactions.size() +1  + " --> A transaction to debit "+ amount +" declined due to insufficent funds.");
			return "Insufficient balance";
		}	
	}
	
	protected String credit(double amount) {
		
		balance+=amount;
		transactions.add(transactions.size() +1  + " --> " +amount+ " credited to account; Balance: "+balance);
		return amount + " credited to account";
	}
	
	protected void statement() {
		transactions.stream().forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer c 	= 	new Customer("keerthi");
		Account a 	= 	new Account(1, "123", 10000, c);
		
		System.out.println(a.debit(1000));
		System.out.println(a.debit(8500));
		System.out.println(a.debit(1000));
		System.out.println(a.credit(1000));
		System.out.println(a.debit(1000));
		System.out.println("--------------------------------------------------------------------------");
		a.statement();

	}

}
