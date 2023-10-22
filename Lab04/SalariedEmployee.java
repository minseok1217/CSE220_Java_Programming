package java_lab4;

public class SalariedEmployee extends Employee{
	private double weeklySalary;
	
	public SalariedEmployee(String first,String last,String social,double weekly) {
		super(first,last,social);
		this.weeklySalary=weekly;
	}
	
	public void setWeeklySalary(double weekly) {
		this.weeklySalary=weekly;
	}
	
	public double getWeeklySalary() {
		return this.weeklySalary;
	}
	
	public double earnings() {
		return this.weeklySalary;
	}
	
	public String toString() {
        return "SalariedEmployee: " + this.getfirstName() + " " + this.getLastName() + " "+ "Eamings(): " + earnings();
    }
}
