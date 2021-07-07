package miniproject1;

public class Customer {
	
	protected String name;
	private String aadhar = "";
	private String pan = "";;
	private String mail = "";
	private String phone = "";
	
	final String aadhar_regex = "[0-9]{12}$";
	final String pan_regex = "[a-zA-Z]{5}[0-9]{4}[a-zA-z]{1}";
	final String mail_regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
	final String phone_regex = "[0-9]{10}$";

	
	Customer(String name, String mail, String aadhar, String pan, String phone) {
		super();
		this.name = name;
		setAadhar(aadhar);
		setMail(mail);
		setPan(pan);
		setPhone(phone);
	}
	
	Customer(Customer c){
		super();
		this.name = c.name;
//		setAadhar(c.aadhar);
//		setMail(c.mail);
//		setPan(c.pan);
//		setPhone(c.phone);
	}
	
	public Customer(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	//-----------------------------------------------------Setters------------------------------------------------------
	private void setAadhar(String a) {
		if(a.matches(aadhar_regex) )	// aadahar has only 12 digits
			this.aadhar = a;
		else	
			System.out.println("Enter a proper Aadhar number");
	}
	private void setPan(String pan) { 
		if(pan.matches(pan_regex))	// pan format --> AAAPZ1234C
			this.pan = pan;
		else
			System.out.println("Enter a proper pan number");		
	}
	protected void setMail(String mail) {
		if(mail.matches(mail_regex))
			this.mail = mail;
		else
			System.out.println("Enter a proper mail id");
	}
	protected void setPhone(String phone) {
		if(phone.matches(pan_regex) )	// phone number has only 10 digits
			this.phone = phone;
		else	
			System.out.println("Enter a proper phone number");
	}
//----------------------------------------------------- getters ------------------------------------------------------
	protected  boolean verifyAadhar(String a) {
		return aadhar.equals(a);
	}
	protected boolean verifyPan(String p) {
		return pan.equalsIgnoreCase(p);
	}	
	protected String getMail() {
		return mail;
	}
	protected String getPhone() {
		return phone;
	}
}
