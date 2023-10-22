package java_lab4;

public class Employee{
	private String firstName;
	private String lastName;
	private String socialSecurityNember;
	
	public Employee(String s1, String s2,String s3) {
		this.firstName=s1;
		this.lastName=s2;
		this.socialSecurityNember=s3;
	}
	
	public void setfirstName(String name) {
		this.firstName=name;
	}
	
	public String getfirstName() {
		return this.firstName;
	}
	
	public void setLastName(String name) {
		this.lastName=name;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setSocialSecurityNumber(String name) {
		this.socialSecurityNember=name;
	}
	
	public String getSocialSecurityNumber() {
		return this.socialSecurityNember;
	}
	
	public double earnings() {
		double ic=0.0;
		return ic;
	}
	
	public String toString() {
        return "Employee: " + firstName + " " + lastName;
    }
	
}
