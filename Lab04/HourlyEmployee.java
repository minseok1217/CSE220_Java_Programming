package java_lab4;

public class HourlyEmployee extends Employee{
	private double wage;
	private double hours;
	
	public HourlyEmployee(String first,String last, String social, double wage, double hours) {
		super(first,last,social);
		this.wage=wage;
		this.hours=hours;
	}
	
	public void setWage(double wage) {
		this.wage=wage;
	}
	
	public double getWage() {
		return this.wage;
	}
	
	public void setHours(double hours) {
		this.hours=hours;
	}
	
	public double getHours() {
		return this.hours;
	}
	
	public double earnings() {
		return this.wage*this.hours;
	}
	
	public String toString() {
        return "HourlyEmployee: " + this.getfirstName() + " " + this.getLastName() +" "+ "Eamings(): " + earnings();
    }
}
