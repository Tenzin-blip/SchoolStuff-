package bankingSystem;

public class Customer {
private String fname;
private String lname;

public Customer(String fname, String lname) {
	this.fname = fname;
	this.lname = lname;
}
public void setFirstName(String fname) {
	this.fname=fname;
}
public void setLastName(String lname) {
	this.lname=lname;
}

public String getFirstName() {
	return fname;
}
public String getLastName() {
	return lname;
}
}